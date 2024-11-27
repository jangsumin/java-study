package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			while (true) {
				System.out.print("> ");
				
				String domain = br.readLine();
				if (domain.equals("exit")) return;

				InetAddress[] InetAddresses = InetAddress.getAllByName(domain);
				for (InetAddress inetAddress : InetAddresses) {
					System.out.println(domain + " : " + inetAddress.getHostAddress());
				}
			}	
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
