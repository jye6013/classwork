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
	
	public String getReportString() {
		String name;
		String spaces;
		if (last.length() > 20) {
			
			for (int i = 0; i < last.length(); i++) {
				if (i < last.length() -3) {
					
				}
			}
		}
		if (first.length() > 20) {
			
			for (int i = (first.length()) -3; i < first.length(); i++) {
				first.substring(i-1, i) = " ";
			}
		}	
		
		for (int i = 1; i <20; i++)	{
			spaces.substring(i-1, i) = " ";
		}
		name += last + spaces + first;
		//name.substring(40, endIndex)
		
	}
}