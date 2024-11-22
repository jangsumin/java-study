package chapter03;

public class StudentTest02 {

	public static void main(String[] args) {
		Student s1 = new Student();
		
		Person p1 = s1; // up-casting(Implicitly)
		
		Student s2 = (Student) p1; // down-casting(Explicitly)
	}

}
