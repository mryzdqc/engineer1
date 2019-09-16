package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import entity.Custom;
public interface CustomDao {
//	@Select("select count(*) from  Crm_custom   ${where}")
//	public int getSize(SeachInfo where);
//
//	@Select("select Crm_custom.* from  Crm_custom   ${where} ${sort} ${limit}")
//	public  List<Custom> getWhere(SeachInfo where);
	
	@Select("select count(1) from crm_custom inner join crm_exitstate on crm_custom.exitstateid=crm_exitstate.id ${name}")
	public int selectCount(@Param("name") String name);
	
	@Select("select crm_custom.* ,exname from crm_custom inner join crm_exitstate on crm_custom.exitstateid=crm_exitstate.id   ${name} ${limit}")
	 public List<Custom> select(@Param("name") String name,@Param("limit") String limit);
	
	@Select("select Crm_custom.* from  Crm_custom ")
	public  List<Custom> getAll();

	@Select("select Crm_custom.* from Crm_custom  where id=#{id}")
	public  Custom getByid(Integer id);

	@Delete("delete from Crm_custom where id=${id}")
	public int delete(@Param("id") Integer id);

	@Insert("insert into Crm_custom (cusname,sex,tel,qq,userid,asstateid,selstateid,exitstateid) values(#{cusname},#{sex},#{tel},#{qq},#{userid},#{asstateid},#{selstateid},#{exitstateid})")
	public Integer insert(Custom t);

	@Update("update Crm_custom set cusname=#{cusname},sex=#{sex},tel=#{tel},qq=#{qq},userid=#{userid},asstateid=#{asstateid},selstateid=#{selstateid},exitstateid=#{exitstateid} where id=#{id}")
	public Integer update(Custom t);

}
