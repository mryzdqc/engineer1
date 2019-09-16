package entity;


import java.io.Serializable;

public class User implements Serializable{

	private Integer id;
	private String username;
	private String userpass;
	private String tel;
	private Integer roleid;
	private Integer ustatuid;
	private String ustatuname;
	
	public String getUstatuname() {
		return ustatuname;
	}


	public void setUstatuname(String ustatuname) {
		this.ustatuname = ustatuname;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String username, String userpass) {
		super();
		this.username = username;
		this.userpass = userpass;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}


	public Integer getUstatuid() {
		return ustatuid;
	}


	public void setUstatuid(Integer ustatuid) {
		this.ustatuid = ustatuid;
	}

	
	
	
	
}

