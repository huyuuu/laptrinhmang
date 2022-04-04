package a123;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CTChinh {

	public static void main(String[] args) throws IOException {
		// mở cổng bắt đầu nghe
		ServerSocket socketServer = new ServerSocket(9999);
		System.out.print("Tôi lắng nghe trong cổng 9999  ...");
		int id =0;
		while(true) {
			Socket s = socketServer.accept();
			LuongA luongTask = new LuongA(s, id);
			luongTask.start();
		}
	}


}