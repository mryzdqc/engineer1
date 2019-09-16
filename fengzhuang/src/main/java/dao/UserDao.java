package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import entity.User;

@Repository
public interface UserDao {

	@Select("select crm_operator.* from  crm_operator  where username=#{username} and userpass=#{userpass}")
	public  User login(User u);

	@Select("select count(1) from crm_operator inner join crm_userstate on crm_operator.ustatuid=crm_userstate.id  ${name}")
	public int selectCount(@Param("name") String name);
	
	@Select("select crm_operator.* ,ustatuname from crm_operator inner join crm_userstate on crm_operator.ustatuid=crm_userstate.id ${name} ${limit}")
	public List<User> select(@Param("name") String name,@Param("limit") String limit);
	 
	@Select("select crm_operator.* from  crm_operator   ${where}")
	public  List<User> getWhere(@Param("where") String where);

	@Select("select crm_operator.* from crm_operator ")
	public  List<User> getAll();

	@Select("select crm_operator.* from crm_operator  where id=#{id}")
	public  User getByid(Integer id);

	@Delete("delete from crm_operator where id=#{id}")
	public int delete(Integer id);

	 @Insert("insert into crm_operator (username,tel,ustatuid) values(#{username},#{tel},#{ustatuid})")
	 public Integer insert(User t);

	 @Update("update crm_operator set username=#{username},tel=#{tel},ustatuid=#{ustatuid} where id=#{id}")
	 public Integer update(User t);

}
