package db2.stream.wikipedia.esper;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Main {

	public static void main(String[] args){
		EsperEngine engine = new EsperEngine();

		try {
		
			engine.configure();
			engine.startWatching();
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch(UnsupportedEncodingException ue){
			ue.printStackTrace();
		}
	}
}
