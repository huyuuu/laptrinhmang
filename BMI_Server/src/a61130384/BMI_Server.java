package a61130384;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BMI_Server {

	public static void main(String[] args) {
		try {
			// mở cổng và bắt đầu nghe
			ServerSocket socketServer = new ServerSocket(8989);
			System.out.println("I'm listening on 8989 port....");
			// luôn luôn lắng nghe
			while(true)
			{
					// khi có 1 yêu cầu tới, ,thì Accept
					// mở 1 Socket để làm viêc với client đó
					Socket socketClient =  socketServer.accept(); // 
					System.out.print(socketClient.getInetAddress().getHostAddress());
				//  lấy về luồng xuất			
					OutputStream osTcClient = socketClient.getOutputStream();
					OutputStreamWriter Write2Client = new OutputStreamWriter(osTcClient);
					BufferedWriter buffwrite = new BufferedWriter(Write2Client);
					
					InputStream in = socketClient.getInputStream();
					InputStreamReader inReader = new InputStreamReader(in); 
					BufferedReader buffRead = new BufferedReader(inReader);
					// ===== Giao tiếp theo giao thức thiết kế============
					while(true)
					{
						// ---server gửi qua client-----------------------
						String chuoiHello_gui = "Hello";
						buffwrite.write(chuoiHello_gui + "\n");
						buffwrite.flush();
					
						// ----Nhận phản hồi xin chào từ client và hỏi tên--
						String chuoiXinchao_nhan = buffRead.readLine();
						String chuoiHoiTen_gui = "bạn tên gì \n";
						buffwrite.write(chuoiHoiTen_gui + "\n");
						buffwrite.flush();
						
						// ----Nhận trả lời tên, và hỏi chiều cao------------
						String chuoiTraloiten_nhan = buffRead.readLine();
						
						String chuoiHoiChieuCao_gui = "bạn cao bao nhiêu cm \n";
						buffwrite.write(chuoiHoiChieuCao_gui + "\n");
						buffwrite.flush();
						
						// ----Nhận trả lời chiều cao và cân nạng------------
						String huoiTraloichieucao_nhan = buffRead.readLine();
						float chieucaoValue = in.read();
						String chuoihoicannang = "bạn nặng bao nhiêu kg \n";
						buffwrite.write(chuoihoicannang + "\n");
						buffwrite.flush();
					
						
						// nhận về cân nặng, gửi tôi đang tính=======
						String chuoicannang = buffRead.readLine();
						float cannangValue = in.read();
						String chuoinoitoidangtinh = "tôi đang tính toán...";
						buffwrite.write(chuoinoitoidangtinh + "\n");
						buffwrite.flush();
						
						
						// tính toán BMI ở đây =========================
							// các lệnh ở đây
						float bmi = cannangValue/(chieucaoValue*chieucaoValue);
						
						String chuoikq_gui;
						if(bmi < 16){
							chuoikq_gui = "Thiếu cân nặng ";
				        }else if(bmi < 18.5){
				        	chuoikq_gui = "Dưới cân nặng";
				        }else if(bmi >= 18.5 && bmi <= 24.9){
				        	chuoikq_gui = "Cân nặng bình thường";
				        }else if (bmi >= 25 && bmi <= 29.9){
				        	chuoikq_gui = "Thừa cân";
				        }else{
				        	chuoikq_gui = "Béo phì";
				        }
						

						
							// đổi mấy tham số từ chuỗi sang số mới tính đc
						buffwrite.write(chuoikq_gui + "\n");
						buffwrite.flush();
						
						//

					}	
					//socketClient.close();
				}
			}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

}