package db2.stream.wikipedia.esper;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

import db2.stream.wikipedia.domain.WikiStream;
import db2.stream.wikipedia.provider.StreamProvider;
import db2.stream.wikipedia.util.Constant;

public class EsperEngine {
	
	private Configuration cepConfig;
	private EPServiceProvider cep;
	private ResourceBundle properties;
	
	public EsperEngine(){
		properties = ResourceBundle.getBundle("esper");
	}
	
	public void configure() throws FileNotFoundException, UnsupportedEncodingException {
		
		cepConfig = new Configuration();
		cepConfig.addEventType(properties.getString("event"), WikiStream.class.getName());
		cep = EPServiceProviderManager.getDefaultProvider(cepConfig);
		
		EPAdministrator cepAdm = cep.getEPAdministrator();
		
		EPStatement statement1 = cepAdm.createEPL(properties.getString("query1"));
		statement1.addListener(new CEPListener(Constant.OPTION_1));
		EPStatement statement2 = cepAdm.createEPL(properties.getString("query2"));
		statement2.addListener(new CEPListener(Constant.OPTION_2));
		EPStatement statement2_1 = cepAdm.createEPL(properties.getString("query2_1"));
		statement2_1.addListener(new CEPListener(Constant.OPTION_2_1));
		EPStatement statement3 = cepAdm.createEPL(properties.getString("query3"));
		statement3.addListener(new CEPListener(Constant.OPTION_3));
		EPStatement statement4 = cepAdm.createEPL(properties.getString("query4"));
		statement4.addListener(new CEPListener(Constant.OPTION_4));
		EPStatement statement5 = cepAdm.createEPL(properties.getString("query5"));
		statement5.addListener(new CEPListener(Constant.OPTION_5));		
	}
	
	public void startWatching() throws InterruptedException{
		//We start watching after the events
		EPRuntime cepRT = cep.getEPRuntime();
		StreamProvider provider = new StreamProvider();
		provider.startMission(cepRT);
		Thread.sleep(1000);
	}

}
