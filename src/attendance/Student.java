package attendance;

public class Student implements Attendee {
	private String first;
	private String last;
	private boolean present;
	
	public Student (String firstName, String lastName) {
		this.first = firstName;
		this.last = lastName;
		present = false;
	}
	
	public boolean isPresent() {
		return present;
	}
	
	public void setPresent(boolean present) {
		this.present = present;
	}
	
	public String getFirstName() {
		return first;
	}
	
	public String getLastName() {
		return last;
	}
	
	public boolean matches(String first, String last) {
		return first.toLowerCase().equals(first.toLowerCase()) && last.toLowerCase().equals(last.toLowerCase());
	}
	
	public boolean matches(String last) {
		return last.toLowerCase().equals(last.toLowerCase());
	}
	
	public String addSpace(String x, int length) {
		if (x.length() < length) {
			x += "";
		}
		return x;
	}
	
	public String getReportString() {
		String studentStatus = last;
		studentStatus = addSpace(studentStatus, 20);
		studentStatus += first;
		studentStatus = addSpace(studentStatus, 40);
		
		if (present == true) {
			studentStatus += "PRESENT";
		}
		else {
			studentStatus += "ABSENT";
		}
		
		return studentStatus;
	}
}
