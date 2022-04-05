package huy61130384;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class LuongLamViec extends Thread{
	Socket socketClient;
	int id=-1;	
	public LuongLamViec(Socket socketClient, int id) {
		super();
		this.socketClient = socketClient;
		this.id = id;
	}
	public void run() {
		try {
			System.out.print(socketClient.getInetAddress().getHostAddress());
			System.out.print(id);
			
			OutputStream osToClient = socketClient.getOutputStream();
			OutputStreamWriter write2client = new OutputStreamWriter(osToClient);
			BufferedWriter buffWrite = new BufferedWriter(write2client);
			
			InputStream in = socketClient.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in);
			BufferedReader buffRead = new BufferedReader(inReader);
			
			while(true){
				String chuoiNhan=buffRead.readLine();
				System.out.print(chuoiNhan);
				String chuoiGui=chuoiNhan;
				buffWrite.write(chuoiGui +"\n");
				buffWrite.flush();
				if(chuoiGui.equals("Bye")) break;			
								
			}
			socketClient.close();
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
}