import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.Timer;

public class Student {
	private String fName, lName, idNum, timeIn, timeOut;
	private Timer timer;
	private Calendar calendar;
	private int minPassed;
	private Date date;
	
	//Constructors of Student
	public Student(String firstName, String lastName, String id) {
		fName = firstName;
		lName = lastName;
		idNum = id;
		timeIn = timeOut = "---";
		timer = new Timer(6000,new TimerListener());
		date = new Date();
		calendar = GregorianCalendar.getInstance();
	}
	public Student(String firstName, String lastName, String id, String in, String out) {
		fName = firstName;
		lName = lastName;
		idNum = id;
		timeIn = in;
		timeOut = out;
		timer = new Timer(6000,new TimerListener());
		date = new Date();
		calendar = GregorianCalendar.getInstance();
	}
	
	//returns full name of student in position i of stuList
	public String getFullName(){
		return (fName + " " + lName + " " + idNum);
	}
	
	//returns first name
	public String getFName() {
		return fName;
	}
	
	//returns last name
	public String getLName() {
		return lName;
	}
	
	//returns ID number
	public String getID() {
		return idNum;
	}
	
	//returns clock-in time
	public String getTimeIn(){
		return timeIn;
	}
	
	//returns clock-out time
	public String getTimeOut(){
		return timeOut;
	}
	
	//returns current time
	public String getTime() {
		date = new Date();
		calendar.setTime(date);
		if(calendar.get(Calendar.MINUTE)>=10)
			return calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
		else
			return calendar.get(Calendar.HOUR_OF_DAY) + ":0" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
	}
	
	//returns current date
	public String getDate() {
		date = new Date();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.YEAR);
	}
	
	//sets clock-in time as 'time'
	public void setClockIn(String time){
		timeIn = time;
	}
	
	//sets clock-in time as current time and
	//starts the time for automatic clock out.
	public void clockIn() {
		autoClockOut();
		timeIn = getTime();
	}
	
	//clocks out the student
	public void clockOut() {
		timeOut = getTime();
	}
	
	//automatically times and clocks out the student
	public void autoClockOut() {
		timer.start();
	}
	
	//sets clock-out time
	public void setClockOut(String time){
		timeOut = time;
	}
	
	public class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(minPassed < 47)
				minPassed++;
			else if(minPassed >= 47){
				setClockOut("AAA");
				timer.stop();
			}
		}
	}
}