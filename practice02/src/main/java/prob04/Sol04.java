package prob04;
public class Sol04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);
		
		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		int len = str.length();
		char[] newC = new char[len];
		for (int i = 0; i < len; i++) {
			newC[len - 1 - i] = str.charAt(i);
		}
		return newC;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
	}
}