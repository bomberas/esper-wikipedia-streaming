package polimi.db2.stream.twitter.main;

import polimi.db2.stream.twitter.domain.Tweet;

import com.espertech.esper.client.EPRuntime;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAPI {
	public void catchTweet(final EPRuntime cepRT) throws TwitterException {
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).
                setOAuthConsumerKey("Ye1TxI2L45gVmHArRiHtuw04H").
                setOAuthConsumerSecret("ssV53zrar3F6wTUqP1EQ3ZDt9v52xMYscwMgLaERqeZIq724Yl").
                setOAuthAccessToken("707215741750276096-Kpm966FIiYlP8f7doq6fT13R6k1UJfk").
                setOAuthAccessTokenSecret("RgMEf9OiuAxGD32bxNChPtUEt55OsmwcmYmKB7wZuvJcU");
        
        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
        StatusListener listener = new StatusListener() {

            public void onStatus(Status status) {
                
                
                if (status != null) {
                	boolean hasPicture = ((status.getMediaEntities() != null && status.getMediaEntities().length > 0))? true : false;
                	
                	Tweet tweet = new Tweet(status.getRetweetCount(),status.getText(),status.isRetweeted(),
                			"", status.getSource(), status.isFavorited(), "",
                			status.isTruncated(), status.getCreatedAt().toString(), hasPicture);
                	
                	System.out.println("Sending this tweet:" + tweet.toString());
                	cepRT.sendEvent(tweet);
                }
            }

            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
            }

            
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }

            
            public void onScrubGeo(long userId, long upToStatusId) {
                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }

            
            public void onStallWarning(StallWarning warning) {
                System.out.println("Got stall warning:" + warning);
            }

            
            public void onException(Exception ex) {
                ex.printStackTrace();
            }
        };
        twitterStream.addListener(listener);
        twitterStream.sample();
    }
	
	/*
        
            TwitterFactory tf=new TwitterFactory (cb.build());
            Twitter twitter =tf.getInstance();
            List<Status> status = twitter.getHomeTimeline();
            
            for (Status st: status){
            	System.out.println("***********************************");
            			System.out.println(st.toString());
            	 
            	 if (st.getMediaEntities() != null && st.getMediaEntities().length > 0){
            		 System.out.println("With picture");
            		 System.out.println(st.getMediaEntities()[0].getMediaURL());
            	 } else {
            		 System.out.println("Without picture");
            	 }
            	 System.out.println("***********************************"); 
            }
            
        }
*/
}
