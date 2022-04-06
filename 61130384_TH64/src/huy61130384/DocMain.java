package huy61130384;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DocMain {

	public static void main(String[] args) throws IOException {
		ServerSocket socketServer = new ServerSocket(9999);
		System.out.println("I'm listening on port 9999");
		int id=0;
		while(true) {
			Socket s = socketServer.accept();
			id++;
			Luonglamviec luongTask = new Luonglamviec(s, id);
			luongTask.start();
		}
	}

}