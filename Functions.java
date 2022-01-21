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
