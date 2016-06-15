package polimi.db2.stream.twitter.main;

import polimi.db2.stream.twitter.domain.Tweet;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

import twitter4j.TwitterException;

public class Engine {
	
	private Configuration cepConfig;
	private EPServiceProvider cep;
	

	
	public void configure() {
		
		
		cepConfig = new Configuration();
		cepConfig.addEventType("Tweet", Tweet.class.getName());
		cep = EPServiceProviderManager.getDefaultProvider(cepConfig);
		
		EPAdministrator cepAdm = cep.getEPAdministrator();
		
		// Holds information about the percentage of tweets that have at least a picture included.
		EPStatement statement1 = cepAdm.createEPL("select (count(*, hasPicture=true)/count(*))*100 from Tweet.win:time(10 sec) output snapshot every 5 sec");
		statement1.addListener(new Listener(1));
		
		//Holds information about the number of tweets registered the last 20 secs.
		EPStatement statement2 = cepAdm.createEPL("select count(*) from Tweet.win:time(20 sec) output snapshot every 1 sec");
		statement2.addListener(new Listener(2));
		
		
		//Holds information about the percentage of tweets that have been retweeted.
		EPStatement statement3 = cepAdm.createEPL("select (count(*, retweeted=true)/count(*))*100 from Tweet.win:time(3 min) output snapshot every 1 sec");
		statement3.addListener(new Listener(3));
		
		
		//Holds information about the percentage of tweets that have been favorited.
		EPStatement statement4 = cepAdm.createEPL("select (count(*, favorited=true)/count(*))*100 from Tweet.win:time(3 min) output snapshot every 1 sec");
		statement4.addListener(new Listener(4));
		
		
		//Holds information about the number of tweets that contains a mention.
		EPStatement statement5 = cepAdm.createEPL("select count(*) from Tweet.win:time(2 min) where text like '%@%' output snapshot every 1 sec");
		statement5.addListener(new Listener(5));
	}
	
	public EPRuntime getRuntime(){
		return cep.getEPRuntime();
	}
	
	public void startWatching() throws InterruptedException, TwitterException{
		//We start watching after the events
		EPRuntime cepRT = cep.getEPRuntime();
		TwitterAPI api = new TwitterAPI();
		api.catchTweet(cepRT);
		Thread.sleep(1000);
	}
	
		
	}



