package db2.stream.wikipedia.esper;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

import db2.stream.wikipedia.util.Constant;

public class CEPListener implements UpdateListener {
	
	private int key;
	
	public CEPListener(int key){
		this.key = key;
	}
	
	public void update(EventBean[] newData, EventBean[] oldData) {
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
		
		PrintWriter writer;
		
		switch (key) {
			
				case Constant.OPTION_1:
					try {
						writer = new PrintWriter("d:/results/query1_"+ System.nanoTime() +".txt", "UTF-8");
						System.out.println(format.format(d) + " - Query 1 Result: " + newData[0].getUnderlying());
						writer.println(format.format(d) + ": Percentage of edit by bots: " + newData[0].getUnderlying() + "\n");
						writer.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					break;
				case Constant.OPTION_2:
					try {
						writer = new PrintWriter("d:/results/query2_"+ System.nanoTime() +".txt", "UTF-8");
						System.out.println(format.format(d) + " - Query 2 Result: " + newData[0].getUnderlying());
						writer.println(format.format(d) + ": Count of human edit folloed by bot edits: " + newData[0].getUnderlying() + "\n");
						writer.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					break;
				case Constant.OPTION_2_1:
					try {
						writer = new PrintWriter("d:/results/query2_1_"+ System.nanoTime() +".txt", "UTF-8");
						System.out.println(format.format(d) + " - Query 2_1 Result: " + newData[0].getUnderlying());
						writer.println(format.format(d) + ": Count of human edit folloed by bot edits (alternative): " + newData[0].getUnderlying() + "\n");
						writer.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					break;	
				case Constant.OPTION_3:
					try {
						writer = new PrintWriter("d:/results/query3_"+ System.nanoTime() +".txt", "UTF-8");
						System.out.println(format.format(d) + " - Query 3 Result: " + newData[0].getUnderlying());
						writer.println(format.format(d) + ": Number of edits by bots: " + newData[0].getUnderlying() + "\n");
						writer.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					break;
				case Constant.OPTION_4:
					try {
						writer = new PrintWriter("d:/results/query4_"+ System.nanoTime() +".txt", "UTF-8");
						System.out.println(format.format(d) + " - Query 4 Result: " + newData[0].getUnderlying());
						writer.println(format.format(d) + ": Rate of arrival of events: " + newData[0].getUnderlying() + "\n");
						writer.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					break;
				case Constant.OPTION_5:
					try {
						writer = new PrintWriter("d:/results/query5_"+ System.nanoTime() +".txt", "UTF-8");
						System.out.println(format.format(d) + " - Query 5 Result: " + newData[0].getUnderlying());
						writer.println(format.format(d) + ": Average of edits per bot: " + newData[0].getUnderlying() + "\n");
						writer.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					break;
		 }	
		
		
	}
}