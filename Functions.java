package application.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Functions {
	Socket requestSocket;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message;
	    
	public Functions(){}
	public void sign_up(String id, String password)
	{
		try{
	        requestSocket = new Socket("1.201.151.37", 2004);
	         
	        out = new ObjectOutputStream(requestSocket.getOutputStream());
	        out.flush();
	        in = new ObjectInputStream(requestSocket.getInputStream());
	        //3: Communicating with the server
	         
			try{
				out.writeObject("SUC");
				out.flush();
				out.writeObject(id);
				out.flush();
				out.writeObject(password);
				out.flush();
			 }
			 catch(IOException ioException){
				    ioException.printStackTrace();
			 }        
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			 //4: Closing connection
			try{
			    in.close();
			    out.close();
			    requestSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}
	   
	void call_SUU(String password)
	{
		try{
			
			requestSocket = new Socket("1.201.151.37", 2004);
			
			
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			//3: Communicating with the server
			
			try{
				out.writeObject("SUU");
				out.flush();
				
				out.writeObject(password);
				out.flush();
				
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
			
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				out.close();
				requestSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		String id = "";
		String password = "";
		Functions client = new Functions();
		client.sign_up(id, password);
	}
}


public class Call_SUR {
	Socket requestSocket;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message;
	
	public Call_SUR() {}
	void call_SUR(String id, String password) {
		try {
			
			 requestSocket = new Socket("1.201.151.37", 2004);
			
			
			 out = new ObjectOutputStream(requestSocket.getOutputStream());
			 out.flush();
			 in = new ObjectInputStream(requestSocket.getInputStream());
			 //3: Communicating with the server
			
			 try{
				 out.writeObject("SUR");
				 out.flush();
				 out.writeObject(id);
				 out.flush();
				 out.writeObject(password);
				 out.flush();
				
			 }
			 catch(IOException ioException){
				 ioException.printStackTrace();
			 }
			
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				out.close();
				requestSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		String id = "";
		String password = "";
		Call_SUR client = new Call_SUR();
		client.call_SUR(id, password);
	}

}

public class Call_SUD {
	Socket requestSocket;
	ObjectOutputStream out;
 	ObjectInputStream in;
 	
 	
	public Call_SUD(){}
	void call_SUD()
	{
		try{
			
			requestSocket = new Socket("1.201.151.37", 2004);
			
			
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			//3: Communicating with the server
			
			try{
				out.writeObject("SUD");
				out.flush();
				
				
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
			
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				out.close();
				requestSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		Call_SUD client = new Call_SUD();
		client.call_SUD();
	}


}


public class Call_SUD {
	Socket requestSocket;
	ObjectOutputStream out;
 	ObjectInputStream in;
 	
 	
	public Call_SUD(){}
	void call_SUD()
	{
		try{
			
			requestSocket = new Socket("1.201.151.37", 2004);
			
			
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			//3: Communicating with the server
			
			try{
				out.writeObject("SUD");
				out.flush();
				
				
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
			
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				out.close();
				requestSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		Call_SUD client = new Call_SUD();
		client.call_SUD();
	}


}


public class Call_GGR {
	Socket requestSocket;
	ObjectOutputStream out;
 	ObjectInputStream in;
 	
 	
	public Call_GGR(){}
	void call_GGR(int order)
	{
		try{
			
			requestSocket = new Socket("1.201.151.37", 2004);
			
			
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			//3: Communicating with the server
			
			try{
				out.writeObject("GGR");
				out.flush();
				out.writeObject(order);
				out.flush();
				
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
			
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				out.close();
				requestSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		int order = 0;
		Call_GGR client = new Call_GGR();
		client.call_GGR(order);
	}


}


public class Call_GGD {
	Socket requestSocket;
	ObjectOutputStream out;
 	ObjectInputStream in;
 	
 	
	public Call_GGD(){}
	void call_GGD(int order, int lineNum)
	{
		try{
			
			requestSocket = new Socket("1.201.151.37", 2004);
			
			
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			//3: Communicating with the server
			
			try{
				out.writeObject("GGD");
				out.flush();
				out.writeObject(order);
				out.flush();
				out.writeObject(lineNum);
				out.flush();
				
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
			
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				out.close();
				requestSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		int order = 0, lineNum = 0;
		Call_GGD client = new Call_GGD();
		client.call_GGD(order, lineNum);
	}

}


public class Call_GGC {
	Socket requestSocket;
	ObjectOutputStream out;
 	ObjectInputStream in;
 	
 	
	public Call_GGC(){}
	void call_GGC(String date, String name, String category, String incomeExpenditure, int balance, int price)
	{
		try{
			
			requestSocket = new Socket("1.201.151.37", 2004);
			
			
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			//3: Communicating with the server
			
			try{
				out.writeObject("GGC");
				out.flush();
				out.writeObject(date);
				out.flush();
				out.writeObject(name);
				out.flush();
				out.writeObject(category);
				out.flush();
				out.writeObject(incomeExpenditure);
				out.flush();
				out.writeObject(balance);
				out.flush();
				out.writeObject(price);
				out.flush();
				
				
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
			
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				out.close();
				requestSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		String date = "", name = "", category = "", incomeExpenditure = "";
		int balance = 0, price = 0;
		
		Call_GGC client = new Call_GGC();
		client.call_GGC(date, name, category, incomeExpenditure, balance, price);
	}

}



