import java.io.IOException;

public class Tester {
	public static void main(String[] args)throws IOException{
		Student me = new Student("me", "me", "me");
		System.out.println(me.getTime());
		System.out.println(me.getDate());
//		StudentList sl = new StudentList();
//		FileConverter fc = new FileConverter();
//		sl.setList(fc.textToList());
//		StudentLogin stuLog = new StudentLogin(0);
	}

}
