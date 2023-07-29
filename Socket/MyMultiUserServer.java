import java.net.*;
import java.io.*;

class MyMultiUserServer extends Thread{
	Socket skt;
	public MyMultiUserServer(Socket st){
		skt=st;
	}
	public void run(){
	try{
		BufferedReader br=new BufferedReader(new InputStreamReader(skt.getInputStream()));
		PrintStream ps=new PrintStream(skt.getOutputStream());
		String msg;
		StringBuilder sb;
		do{
			msg=br.readLine();
			sb= new StringBuilder(msg);
			//sb.reverse();
			msg=sb.toString();
			ps.println(msg);
			System.out.println("From Client : "+msg);
		}while(!msg.equals("stop"));
		skt.close();
	}catch(Exception e){}
      }
	public static void main(String args[])throws Exception{
	ServerSocket ss= new ServerSocket(2500);
	Socket skt;
	int count=1;
	System.out.println("Server is started. ");
	MyMultiUserServer mus;
	do{
		skt=ss.accept();
		System.out.println("Client Connected: "+count++);
		mus=new MyMultiUserServer(skt);
		
		mus.start();
	}while(true);
   }
}
