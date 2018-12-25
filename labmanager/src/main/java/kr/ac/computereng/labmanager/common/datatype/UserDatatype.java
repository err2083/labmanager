package kr.ac.computereng.labmanager.common.datatype;

public class UserDatatype {
	private String id;
	private String password;
	private String name;
	private String email1;
	private String email2;
	private UserRole role;
	private String study;
	private String hope;
	
	public UserDatatype() {
		role = new UserRole();
	}
	
	public UserRole getRole() {
		return this.role;
	}
	
	public void setRole(UserRole role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	
	public String getStudy() {
		return study;
	}
	public void setStudy(String study) {
		this.study = study;
	}
	public String getHope() {
		return hope;
	}
	public void setHope(String hope) {
		this.hope = hope;
	}
	
	public UserDatatype(String id, String password, String name, String email1, String email2,
			String study, String hope) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email1 = email1;
		this.email2 = email2;
		this.study = study;
		this.hope = hope;
		role = new UserRole(id);
	}	
}
