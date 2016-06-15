package polimi.db2.stream.twitter.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class Listener implements UpdateListener {
	
	private int query;
	
	public Listener(int query){
		this.query = query;
	}

	public void update(EventBean[] newData, EventBean[] oldData) {
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
	
		switch (query) {
		
			case 1:
				Result.strResult1 = "[" + format.format(d) + "] Percentage of tweets with images: " + newData[0].getUnderlying();
				break;
			case 2:
				Result.strResult2 = "[" + format.format(d) + "] Count of tweets: " + newData[0].getUnderlying();
				break;
			case 3:
				Result.strResult3 = "[" + format.format(d) + "] Percentage of retweeted tweets: " + newData[0].getUnderlying();
				break;
			case 4:
				Result.strResult4 = "[" + format.format(d) + "] Percentage of favorites tweets: " + newData[0].getUnderlying();
				break;
			case 5:
				Result.strResult5 = "[" + format.format(d) + "] Number of tweets containing a mention: " + newData[0].getUnderlying();
				break;
		}		
	}
	
}