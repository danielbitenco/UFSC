
public class agendaClass {
	private int id;
	private String name;
	private String address;
	private String email;
	private String phone;
	private String birth;

	public agendaClass(int i, String na, String ad, String em, String ph, String bi) {
		setId(i);
		setName(na);
		setAddress(ad);
		setEmail(em);
		setPhone(ph);
		setBirth(bi);
	}

	public agendaClass() {
		this(0, "", "", "", "", "");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

}
