package entity;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Revisit {
	private Integer id;
	private Timestamp time;
	private Integer userid;
	private Integer cusid;
	private String ques;
	private String method;
	private Integer nextdateid;
	private String comments;
	
	private String username;
	private String cusname;
	
	
	
	
	public String getCusname() {
		return cusname;
	}

	public void setCusname(String cusname) {
		this.cusname = cusname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		long t = time.getTime();
		Date date = new Date(t);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s=sdf.format(date);
		return s;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getCusid() {
		return cusid;
	}

	public void setCusid(Integer cusid) {
		this.cusid = cusid;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Integer getNextdateid() {
		return nextdateid;
	}

	public void setNextdateid(Integer nextdateid) {
		this.nextdateid = nextdateid;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
