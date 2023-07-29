import java.net.*;
import java.io.*;

class MyServer{
	public static void main(String args[]) throws Exception{
	ServerSocket ss= new ServerSocket(2500);
	Socket stk=ss.accept();
	BufferedReader br= new BufferedReader(new InputStreamReader(stk.getInputStream()));
	PrintStream ps= new PrintStream(stk.getOutputStream());
	
	String msg;
	StringBuilder sb;
	System.out.println("Server is Started. ");
	do{
		msg=br.readLine();
		sb= new StringBuilder(msg);
		//sb.reverse();	
		msg=sb.toString();
		ps.println(msg);
		System.out.println("From Client : "+msg);
	}while(!msg.equals("stop"));
    }
}