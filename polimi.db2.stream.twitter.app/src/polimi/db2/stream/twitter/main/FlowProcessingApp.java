package polimi.db2.stream.twitter.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import polimi.db2.stream.twitter.domain.Tweet;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class FlowProcessingApp {


	public static void main(String[] args) {
		
		JFrame f = new JFrame("Flow Processing - Database Systems 2");
	  	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(480, 320);
		
	    JPanel upperPanel = new JPanel();
	    JPanel lowerPanel = new JPanel();
	    f.getContentPane().add(upperPanel, "North");
	    f.getContentPane().add(lowerPanel, "South");
	    
	    final JTextArea txtStreams = new JTextArea("Waiting ...", 30, 115);
	    txtStreams.setEditable(false);
	    JScrollPane scroll = new JScrollPane (txtStreams, 
	    		   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    upperPanel.add(scroll);


	    final JTextArea txtQuery1 = new JTextArea("Waiting ...", 10, 22);
	    txtQuery1.setEditable(false);
	    txtQuery1.setLineWrap(true);
	    txtQuery1.setWrapStyleWord(true);
	    lowerPanel.add(new JScrollPane(txtQuery1));

	    final JTextArea txtQuery2 = new JTextArea("Waiting ...", 10, 22);
	    txtQuery2.setEditable(false);
	    txtQuery2.setLineWrap(true);
	    txtQuery2.setWrapStyleWord(true);
	    lowerPanel.add(new JScrollPane(txtQuery2));

	    final JTextArea txtQuery3 = new JTextArea("Waiting ...", 10, 22);
	    txtQuery3.setEditable(false);
	    txtQuery3.setLineWrap(true);
	    txtQuery3.setWrapStyleWord(true);
	    lowerPanel.add(new JScrollPane(txtQuery3));
	    
	    final JTextArea txtQuery4 = new JTextArea("Waiting ...", 10, 22);
	    txtQuery4.setEditable(false);
	    txtQuery4.setLineWrap(true);
	    txtQuery4.setWrapStyleWord(true);
	    lowerPanel.add(new JScrollPane(txtQuery4));

	    final JTextArea txtQuery5 = new JTextArea("Waiting ...", 10, 22);
	    txtQuery5.setEditable(false);
	    txtQuery5.setLineWrap(true);
	    txtQuery5.setWrapStyleWord(true);
	    lowerPanel.add(new JScrollPane(txtQuery5));
	    
	    
	    //Configuring Stream
	    
	    ConfigurationBuilder cb = new ConfigurationBuilder();
	        cb.setDebugEnabled(true).
	                setOAuthConsumerKey("Ye1TxI2L45gVmHArRiHtuw04H").
	                setOAuthConsumerSecret("ssV53zrar3F6wTUqP1EQ3ZDt9v52xMYscwMgLaERqeZIq724Yl").
	                setOAuthAccessToken("707215741750276096-Kpm966FIiYlP8f7doq6fT13R6k1UJfk").
	                setOAuthAccessTokenSecret("RgMEf9OiuAxGD32bxNChPtUEt55OsmwcmYmKB7wZuvJcU");
	    final TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
	    
	    final JButton buttonStart = new JButton("Start Watching");
	    buttonStart.setSize(10, 10);
	    
	    final JButton buttonStop = new JButton("Stop Watching");
	    buttonStop.setSize(10, 10);
	    buttonStop.setEnabled(false);
	    
	    // adds event handler for button Stop
	    buttonStop.addActionListener(new ActionListener() {
	 			public void actionPerformed(ActionEvent evt) {
	 				twitterStream.shutdown();
	 				buttonStart.setEnabled(true);
	 				buttonStop.setEnabled(false);
	 			}
	    });
	    
	    
	    // adds event handler for button Start
	    buttonStart.addActionListener(new ActionListener() {
	 			public void actionPerformed(ActionEvent evt) {
	 				buttonStart.setEnabled(false);
	 				buttonStop.setEnabled(true);
	 				final Engine engine = new Engine();
	 				engine.configure();
	 				
	 				try {
		 			        StatusListener listener = new StatusListener() {
	
		 			            public void onStatus(Status status) {
		 			                if (status != null) {
		 			                	boolean hasPicture = ((status.getMediaEntities() != null && status.getMediaEntities().length > 0))? true : false;
		 			                	
		 			                	Tweet tweet = new Tweet(status.getRetweetCount(),status.getText(),status.isRetweeted(),
		 			                			"", status.getSource(), status.isFavorited(), "",
		 			                			status.isTruncated(), status.getCreatedAt().toString(), hasPicture);
		 			                	
		 			                	txtStreams.setText("\n" + tweet.toString() + "\n"  + txtStreams.getText());

		 			                	//Sending tweet data to Esper
		 			                	engine.getRuntime().sendEvent(tweet);
		 			                	
		 			                	//Updating the result of queries
		 			                	txtQuery1.setText(Result.strResult1);
		 			                	txtQuery2.setText(Result.strResult2);
		 			                	txtQuery3.setText(Result.strResult3);
		 			                	txtQuery4.setText(Result.strResult4);
		 			                	txtQuery5.setText(Result.strResult5);
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
		 			        
		 			        
	 				
	 				} catch (Exception e) {
	 					e.printStackTrace();
	 				} 
	 			}
	 		});

	    JPanel midPanel = new JPanel();
	    midPanel.add(buttonStart);
	    midPanel.add(buttonStop);
	    f.getContentPane().add(midPanel);
	    
	    f.pack();
	    f.setLocationRelativeTo(null);	// centers on screen
	    f.setVisible(true);
  }
}