package prob05;

public class Sol05 {
	public static void main(String[] args) {

		/* 코드 작성 */
		for (int i = 1; i <= 100; i++) {
			String num = String.valueOf(i);
			
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < num.length(); j++) {
				if (num.charAt(j) != '0' && num.charAt(j) % 3 == 0) {
					sb.append("짝");
				}
			}
			
			if (!sb.isEmpty()) System.out.println(i + " " + sb.toString());
		}
	}
}
