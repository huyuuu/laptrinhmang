package streamsEx;

import java.io.IOException;
import java.io.InputStream;
public class Read1CharByInputStream {
	public static void main(String[] args) {
		//Tạo một lớp đối tượng inputstream
		InputStream is;
		//Gắn nó với luồng nhập chuẩn (Bàn Phím)
		is= System.in;
		//Đọc 1 ký tự
		System.out.print("Mời bạn nhập một ký tự:  ");
		try {
			int kt=is.read();
			//Nơi thực hiện lệnh có khả năng sinh ra lỗi
			System.out.print("Ký tự bạn vừa nhập là: "+(char)kt);
		}catch (IOException e) {
		e.printStackTrace();
			//Nơi xử lý nếu có ngoại lệ xảy ra
		}
	}

}
