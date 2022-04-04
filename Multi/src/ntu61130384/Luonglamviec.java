package ntu61130384;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Luonglamviec extends Thread {
	Socket socketClient;
	int id = -1;
	

	public Luonglamviec(Socket socketClient, int id) {
		super();
		this.socketClient = socketClient;
		this.id = id;
		
	}



	@Override
	public void run() {
		try {
			System.out.print(socketClient.getInetAddress().getHostAddress());
			System.out.print(id);
			OutputStream osToClient = socketClient.getOutputStream();	
			OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
			BufferedWriter buffW = new BufferedWriter(write2Client);
		
			InputStream in = socketClient.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in);
			BufferedReader buffR = new BufferedReader(inReader);
			while(true) {
				String chuoiNhan = buffR.readLine();
				System.out.print(chuoiNhan);
				//Gửi trả
				String chuoiGui = chuoiNhan;
				buffW.write(chuoiGui+"\n");
				buffW.flush();
				if(chuoiGui.equals("Bye")) break;
			}
			socketClient.close();
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
	
	}
}
	