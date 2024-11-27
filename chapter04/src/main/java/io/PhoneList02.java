package io;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhoneList02 {

	public static void main(String[] args) {
		Scanner scanner = null;
		
		try {			
			File file = new File("./phone.txt");
			if (!file.exists()) {
				System.out.println("File Not Found");
				return;
			}
			
			System.out.println("== 파일정보 ==");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			Long timestamp = file.lastModified();
			Date date = new Date(timestamp);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println(sdf.format(date));
			
			System.out.println("== 전화번호 ==");
	
			scanner = new Scanner(file);
			
			// 4. 처리
			String line = null;
			while (scanner.hasNextLine()) {
				String name = scanner.next();
				String phone1 = scanner.next();
				String phone2 = scanner.next();
				String phone3 = scanner.next();
				 
				System.out.println(name + ":" + phone1 + "-" + phone2 + "-" + phone3);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
	}

}
