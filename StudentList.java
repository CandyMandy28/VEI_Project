import java.util.ArrayList;

public class StudentList {

	public static ArrayList < Student > stuList;

	//constructor of StudentList
	public StudentList() {
		stuList = new ArrayList < Student > ();
	}

	//returns size of stuList
	public int size() {
		return stuList.size();
	}

	//returns the Student in index "index" of stuList
	public Student get(int index) {
		return stuList.get(index);
	}
	
	//returns the last student in the list
	public Student getLast(){
		return stuList.get(stuList.size() -1);
	}

	//returns stuList
	public ArrayList < Student > getList() {
		return stuList;
	}

	//returns the position where the match was found in the list
	//returns -1 otherwise
	public int searchID(String idNum) {
		int pos = 0;
		for (Student stu : stuList) {
			String id = stu.getID();
			if(id.compareTo(idNum)==0)
				return pos;
			pos++;
		}
		return -1;
	}

	//sets the student as "object" at position "index"
	public void set(int index, Student object) {
		stuList.set(index, object);
	}

	//sets stuList to stu
	public void setList(ArrayList < Student > stu) {
		stuList = stu;
	}

	//adds a new student to stuList
	public void add(Student name) {
		stuList.add(name);
	}
}