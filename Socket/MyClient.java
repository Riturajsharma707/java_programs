import java.net.*;
import java.io.*;

class MyClient{
	public static void main(String args[])throws Exception{
	Socket skt= new Socket("172.16.21.87",2500);
	BufferedReader keyb= new BufferedReader(new InputStreamReader(System.in));
	BufferedReader br= new BufferedReader(new InputStreamReader(skt.getInputStream()));
	PrintStream ps=new PrintStream(skt.getOutputStream());
	String msg;
	do{
		msg=keyb.readLine();		
		ps.println(msg);
		msg=br.readLine();		
		System.out.println("From Server : "+msg);
	}while(!msg.equals("stop"));
    }
}