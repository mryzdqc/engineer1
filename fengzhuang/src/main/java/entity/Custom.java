package entity;

public class Custom {
	private Integer id;
	private String cusname;
	private String tel;
	private String qq;
	private Integer userid;
	

	private Integer sex;
	public static String[] sexs= {"保密","男","女"};
	public String getSexname() {
		return sexs[sex];
	}
	
	private Integer asstateid;
	public static String[] asstate= {"签约","考虑","拒绝"};
	public String getAsname() {
		return asstate[asstateid];
	}
	
	private Integer selstateid;
	public static String[] selstate= {"有需求","无需求","尚不明确"};
	public String getSelname() {
		return selstate[selstateid];
	}
	
	private Integer exitstateid;
	//public static String[] exitstate= {"","",""};
	private String exname;
	public String getExname() {
		return exname;
	}

	
	
	

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	

	

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCusname() {
		return cusname;
	}

	public void setCusname(String cusname) {
		this.cusname = cusname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getAsstateid() {
		return asstateid;
	}

	public void setAsstateid(Integer asstateid) {
		this.asstateid = asstateid;
	}

	public Integer getSelstateid() {
		return selstateid;
	}

	public void setSelstateid(Integer selstateid) {
		this.selstateid = selstateid;
	}

	public Integer getExitstateid() {
		return exitstateid;
	}

	public void setExitstateid(Integer exitstateid) {
		this.exitstateid = exitstateid;
	}

}
