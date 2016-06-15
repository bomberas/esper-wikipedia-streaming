package db2.stream.wikipedia.provider;

import java.io.IOException;
import java.util.ResourceBundle;

import org.json.JSONException;
import org.json.JSONObject;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIO;
import io.socket.SocketIOException;

import com.espertech.esper.client.EPRuntime;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import db2.stream.wikipedia.domain.WikiStream;

public class StreamProvider {
	
	public void startMission(final EPRuntime cepRT) throws InterruptedException {
		try {
				final ResourceBundle properties = ResourceBundle.getBundle("stream");
				
				final SocketIO socket = new SocketIO(properties.getString("socket.io"));
		        socket.connect(new IOCallback() {
		        	
		            public void onMessage(JSONObject json, IOAcknowledge ack) {
		                try {
		                    System.out.println("Data:" + json.toString(2));
		                } catch (JSONException e) {
		                    e.printStackTrace();
		                }
		            }
		
		            public void onMessage(String data, IOAcknowledge ack) {
		                System.out.println("Server said: " + data);
		            }
		
		            public void onError(SocketIOException socketIOException) {
		                System.out.println("An error has occured");
		                socketIOException.printStackTrace();
		            }
		
		            public void onDisconnect() {
		                System.out.println("Connection terminated.");
		            }
		
		            public void onConnect() {
		                System.out.println("Connection established");
						socket.emit("subscribe", properties.getString("enwiki"));
		            }
		
		            public void on(String event, IOAcknowledge ack, Object... args) {
		            	if(event.equals(properties.getString("event"))){
		
		            		if (args[0] != null ){
		            			ObjectMapper mapper = new ObjectMapper();
		            			try {
									WikiStream stream = mapper.readValue(args[0].toString(), WikiStream.class);
									
									//Only type = new and type = edit
									if (stream != null && properties.getString("type").contains(stream.getType())){
										//We need to send these streams to the Esper engine
										cepRT.sendEvent(stream);
									}
								} catch (JsonParseException e) {
									e.printStackTrace();
								} catch (JsonMappingException e) {
									e.printStackTrace();
								} catch (IOException e) {
									e.printStackTrace();
								}
		            		}
		            	}
		            }
		        });
		
		        socket.send("Hello Server!");
		        
    	} catch (Exception e){
    		e.printStackTrace();
    	}
	}

}
