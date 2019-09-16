package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Userstatu;

@Repository
public interface UserStatuDao  {

	

	@Select("select Crm_userstate.* from  Crm_userstate   ${where}")
	public  List<Userstatu> getWhere(@Param("where") String where);

	@Select("select Crm_userstate.* from  Crm_userstate ")
	public  List<Userstatu> getAll();

	@Select("select Crm_userstate.* from Crm_userstate  where id=#{id}")
	public  Userstatu getByid(@Param("id") Integer id);

	@Delete("delete from Crm_userstate where id=#{id}")
	public int delete(@Param("id") Integer id);

	 @Insert("insert into Crm_userstate (name) values(#{name})")
	 public Integer insert(Userstatu t);

	 @Update("update Crm_userstate set name=#{name} where id=#{id}")
	 public Integer update(Userstatu t);

}
