package polimi.db2.stream.twitter.main;


import twitter4j.TwitterException;

public class Main {
	
	public static void main(String[] args) throws TwitterException{
		Engine engine = new Engine();

		try {
		
			engine.configure();
			engine.startWatching();
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}