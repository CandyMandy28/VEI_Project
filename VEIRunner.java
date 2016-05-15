import java.io.FileNotFoundException;
import java.io.IOException;

//This is the tester class that runs the project
public class VEIRunner{
	public static void main(String[] IAmNumberFour) throws IOException, FileNotFoundException{
		StudentList sl = new StudentList();
		FileConverter fc = new FileConverter();
		sl.setList(fc.textToList());
		LoginFrame login = new LoginFrame();
		login.openWindow();
	}
}