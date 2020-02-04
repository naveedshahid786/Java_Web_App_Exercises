package student_database;

public class Student {
	int id;
	String lastname;
	String firstname;
	String streetaddress;
	String postcode;
	String postoffice;
	public Student(int id, String lastname, String firstname, String streetaddress, String postcode,
			String postoffice) {
		
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.streetaddress = streetaddress;
		this.postcode = postcode;
		this.postoffice = postoffice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getStreetaddress() {
		return streetaddress;
	}
	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPostoffice() {
		return postoffice;
	}
	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}
	@Override
	public String toString() {
		return id + " " + firstname + " " + lastname + " " + streetaddress + " " + postcode + " " + postoffice;
	}
	
	
	
	
}