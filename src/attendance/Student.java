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
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public boolean matches(String first, String last) {
		return first.toLowerCase().equals(firstName.toLowerCase()) && last.toLowerCase().equals(lastName.toLowerCase());
	}
	
	public boolean matches(String last) {
		return last.toLowerCase().equals(lastName.toLowerCase());
	}
	
	public String getReportString() {
		if (lastName.length() > 20) {
			
		}
		
		if (firstName.length() > 20) {
			
		}
	}
}
