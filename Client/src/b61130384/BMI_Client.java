package b61130384;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class BMI_Client {

	public static void main(String[] args) {
		Socket soc;
		try {
			 soc = new Socket("localhost", 9999); // gửi yêu cầu tới server
			
			System.out.print("Connected! \n");
			// --------Lấy luồng nhập, xuất----------------------
			InputStream in = soc.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in); 
			BufferedReader buffRead = new BufferedReader(inReader);
			
			OutputStream osTcClient = soc.getOutputStream();
			OutputStreamWriter Write2Client = new OutputStreamWriter(osTcClient);
			BufferedWriter buffwrite = new BufferedWriter(Write2Client);
			// ---------Lấy chuỗi nhập từ bàn phím---------------
			while(true) {
			Scanner banphim = new Scanner(System.in);
			
			//==========chuỗi nhận nhập a=======================
			
			String chuoiNhapa_nhan = buffRead.readLine();
			
			// in ra dể xem
			System.out.print("\nBMI server :"+chuoiNhapa_nhan );
			// trả lời cho server====================
				// bảo user nhập a từ bàn phím
			System.out.print("\nBMI Client :(nhập a): ");
			String chuoiNhapa_gui = banphim.nextLine();
			// gửi đến server
			buffwrite.write(chuoiNhapa_gui);
			buffwrite.flush();
			//==========chuỗi nhận nhập b=======================
			String chuoiNhapb_nhan = buffRead.readLine();
			// in ra dể xem
			System.out.print("\nBMI server :"+chuoiNhapb_nhan );
			// trả lời cho server====================
				// bảo user nhập a từ bàn phím
			System.out.print("\nBMI Client :(nhập b): ");
			String chuoiNhapb_gui = banphim.nextLine();
			// gửi đến server
			buffwrite.write(chuoiNhapb_gui);
			buffwrite.flush();
			// Nhập phép toán
			String chuoiNhaptinh_nhan = buffRead.readLine();
			// in ra dể xem
			System.out.print("\nBMI server :"+chuoiNhaptinh_nhan );
			// trả lời cho server====================
				// bảo user nhập phép toán từ bàn phím
			System.out.print("\nBMI Client :Nhập phép toán (+, -, *, /)");
			String chuoiNhaptinh_gui = banphim.nextLine();
			// gửi đến server
			buffwrite.write(chuoiNhaptinh_gui);
			buffwrite.flush();
			System.out.println(buffRead.readLine());
			String chuoiGui = banphim.nextLine();
			buffwrite.write(chuoiGui+"\n");
			buffwrite.flush();
			soc.close();
			if(chuoiGui.equals("Không")||chuoiGui.equals("không")) break;
		}
			//==============================================	
			} catch (IOException e) {
				System.out.print("NoConnect....");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
