package student.dto;

public class Student {
	private int s_id;
	private String s_name;
	private String s_email;
	private long s_phone;
	private int s_age;
	private String s_address;
	private double s_marks;
	private int s_rank;
	private String s_password;

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_email() {
		return s_email;
	}

	public void setS_email(String s_email) {
		this.s_email = s_email;
	}

	public long getS_phone() {
		return s_phone;
	}

	public void setS_phone(long s_phone) {
		this.s_phone = s_phone;
	}

	public int getS_age() {
		return s_age;
	}

	public void setS_age(int s_age) {
		this.s_age = s_age;
	}

	public String getS_address() {
		return s_address;
	}

	public void setS_address(String s_address) {
		this.s_address = s_address;
	}

	public double getS_marks() {
		return s_marks;
	}

	public void setS_marks(double s_marks) {
		this.s_marks = s_marks;
	}

	public int getS_rank() {
		return s_rank;
	}

	public void setS_rank(int s_rank) {
		this.s_rank = s_rank;
	}

	public String getS_password() {
		return s_password;
	}

	public void setS_password(String s_password) {
		this.s_password = s_password;
	}

	public Student(int s_id, String s_name, String s_email, long s_phone, int s_age, String s_address, double s_marks, String s_password) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_email = s_email;
		this.s_phone = s_phone;
		this.s_age = s_age;
		this.s_address = s_address;
		this.s_marks = s_marks;
		this.s_password = s_password;
	}

	@Override
	public String toString() {
		return "\nStudent [s_id=" + s_id + ", s_name=" + s_name + ", s_email=" + s_email + ", s_phone=" + s_phone
				+ ", s_age=" + s_age + ", s_address=" + s_address + ", s_marks=" + s_marks + ", s_rank=" + s_rank
				+ ", s_password=" + s_password + "]";
	}

}
