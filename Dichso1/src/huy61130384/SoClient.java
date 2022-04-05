package huy61130384;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;


public class SoClient {
	public static void main(String[] args) {
		try {
			
			Socket socket = new Socket("localhost",9999);
			System.out.println("Kết nối thành công");
			
			InputStream in = socket.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in);
			BufferedReader buffRead = new BufferedReader(inReader);

			OutputStream osToClient = socket.getOutputStream();	
			OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
			BufferedWriter buffWrite = new BufferedWriter(write2Client);

			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.print("\nClient:");
				String chuoiGui = sc.nextLine();
				buffWrite.write(chuoiGui+"\n");
				buffWrite.flush();
				String chuoiNhan = buffRead.readLine();
				System.out.print("Server: "+ chuoiNhan);
				if(chuoiGui.equals("Bye")) break;
			}
			socket.close();
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}

}