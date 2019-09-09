package entity;


import java.io.Serializable;

public class Book implements Serializable{
	//状态列（无数据表，列状态标识，翻译）
	private Integer sex;
	public static String[] sexs= {"不限","男","女"};
	public String getSexname() {
		return sexs[sex];
	}
	
	
	//外键列（有数据表，对象额外描述，扩展表述）
	private Integer typeid;
	private String typename;
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}


	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

}
