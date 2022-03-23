package streamsEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadLine {
	
	public static void main (String[] args) throws IOException {
		
		// Tạo một đối tượng của lớp InputStreamReader
		InputStreamReader isRdr;
		// Gắn nó với luồng nhập chuẩ (Bàn phím)
		isRdr= new InputStreamReader (System.in);
		// Tạo đối tượng BufferedReader
		BufferedReader buffReader = new BufferedReader(isRdr);
		
		// Đọc 1 chuỗi từ bàn phím
		System.out.print("Mời nhập một ký tự: ");
		String strLine= buffReader.readLine();
		// Xuất ra màng hình
		System.out.print("Ký tự bạn vừa nhập là: "+ strLine);
	}

}
