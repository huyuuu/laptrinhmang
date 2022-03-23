package streamsEx;

import java.io.Reader;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Read1CharByReader {
	
	public static void main (String[] args) throws IOException {
		// Tạo một đối tượng của lớp Reader
		InputStreamReader isRdr;
		// Gắn nó với luồn nhập chuẩn (Bàn phím)
		isRdr=new InputStreamReader (System.in);
		// Đọc 1 ký tự
		System.out.print("Mời nhập một ký tự: ");
		int kt= isRdr.read();
		System.out.print("Ký tự bạn vừa nhập là: "+(char)kt);
	}
}
