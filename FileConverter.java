import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class FileConverter {
	private PrintWriter out;
	private File viewFile;
	private StudentList sl;
	private Scanner in;

	//Constructor of FileConverter
	public FileConverter() throws FileNotFoundException, IOException {
		sl = new StudentList();
		viewFile = new File ("VEI_Class.txt");
		out = new PrintWriter(new BufferedWriter(new FileWriter(viewFile, true)));
		in = new Scanner(viewFile);
	}
	
	//adds student to the text files and stuList
	public void addStudent(String firstName,String lastName, String idNum) throws FileNotFoundException, IOException {
		sl.add(new Student(firstName, lastName, idNum));
		out.println(idNum + "\t\t" + firstName + "\t\t" + lastName + "\t\t" + "---" + "\t\t" + "---");
		out.close();
	}

	//opens the viewing file in Notepad
	public void openFile() throws IOException {
		Runtime rt = Runtime.getRuntime();
		String fileName = "VEI_Class.txt";
		Process p = rt.exec("notepad "+ fileName);
	}

	//converts the text files to create 
	public ArrayList < Student > textToList() {
		
		ArrayList < Student > tempStudent = new ArrayList < Student > ();
		while (in.hasNext()) {
			
			String idNum = in.next();
			String fName = in.next();
			String lName = in.next();
			String clockIn = in.next();
			String clockOut = in.next();
			
			Student stu = new Student(fName, lName, idNum, clockIn, clockOut);
			tempStudent.add(stu);
		}
		return tempStudent;
	}

	//returns the total number of lines in a file
	public int countLines(String filename) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean empty = true;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
			}
			return (count == 0 && !empty) ? 1 : count;
		} finally {
			is.close();
		}
	}
}