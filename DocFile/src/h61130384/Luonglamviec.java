package h61130384;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Luonglamviec extends Thread{
	Socket socketClient;
	int id=-1;	
	BufferedWriter buffWrite;
	public Luonglamviec(Socket socketClient, int id) {
		super();	
		this.socketClient = socketClient;
		this.id = id;
	}
		void GuiFile(String tenFile) throws IOException {
			FileReader fr = new FileReader (tenFile);
			BufferedReader buffRead = new BufferedReader(fr);
			
			OutputStream osToClient = socketClient.getOutputStream();
			OutputStreamWriter write2client = new OutputStreamWriter(osToClient);
			BufferedWriter buffWrite = new BufferedWriter(write2client);
			
			String line;
			while ((line = buffRead.readLine()) != null)
			{
				buffWrite.write(line);
				buffWrite.flush();
			}
			fr.close();
	}
		@Override
		public void run() {
			try {
				System.out.print(socketClient.getInetAddress().getHostAddress());
				System.out.print(id);
				OutputStream osToClient = socketClient.getOutputStream();	
				OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
				buffWrite = new BufferedWriter(write2Client);
			
				InputStream in = socketClient.getInputStream();
				InputStreamReader inReader = new InputStreamReader(in);
				BufferedReader buffRead = new BufferedReader(inReader);
				while(true) {
			
				String chuoiNhan=buffRead.readLine();
				System.out.print(chuoiNhan);
				
				if(chuoiNhan.equals("1")) {
					String chuoiGui= "1.txt";
					buffWrite.write(chuoiGui+"\n");
					buffWrite.flush();
				}else if(chuoiNhan.equals("2")) {
					String chuoiGui= "2.txt";
					buffWrite.write(chuoiGui+"\n");
					buffWrite.flush();
				}else if(chuoiNhan.equals("3")) {
					String chuoiGui= "3.txt";
					buffWrite.write(chuoiGui+"\n");
					buffWrite.flush();
				}else if(chuoiNhan.equals("4")) {
					String chuoiGui= "4.txt";
					buffWrite.write(chuoiGui+"\n");
					buffWrite.flush();
				}else if(chuoiNhan.equals("5")) {
					String chuoiGui= "5.txt";
					buffWrite.write(chuoiGui+"\n");
					buffWrite.flush();
				}else if(chuoiNhan.equals("6")) {
					String chuoiGui= "6.txt";
					buffWrite.write(chuoiGui+"\n");
					buffWrite.flush();
				}else if(chuoiNhan.equals("7")) {
					String chuoiGui= "7.txt";
					buffWrite.write(chuoiGui+"\n");
					buffWrite.flush();
				}else if(chuoiNhan.equals("8")) {
					String chuoiGui= "8.txt";
					buffWrite.write(chuoiGui+"\n");
					buffWrite.flush();
				}else if(chuoiNhan.equals("9")) {
					String chuoiGui= "9.txt";
					buffWrite.write(chuoiGui+"\n");
					buffWrite.flush();
				}else if(chuoiNhan.equals("10")) {
					String chuoiGui= "10.txt";
					buffWrite.write(chuoiGui+"\n");
					buffWrite.flush();
				}else if(chuoiNhan.equals("0")) {
					break;
				}		
								
			}
			socketClient.close();
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
}