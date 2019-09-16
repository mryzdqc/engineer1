package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import entity.Revisit;
@Repository
public interface RevisitDao {
	@Select("select count(1) from  Crm_revisit inner join crm_operator on crm_revisit.userid=crm_operator.id "
			+"inner join crm_custom on crm_revisit.cusid=crm_custom.id "
			+ "${where}")
	public int selectCount(@Param("where") String where);

	@Select("select Crm_revisit.* ,username ,cusname from Crm_revisit inner join crm_operator on crm_revisit.userid=crm_operator.id "
			+"inner join crm_custom on crm_revisit.cusid=crm_custom.id "
			+ " ${name} ${limit}")
	public List<Revisit> select(@Param("name") String name,@Param("limit") String limit);
	
	@Select("select Crm_revisit.* from  Crm_revisit ${where} ")
	public  List<Revisit> getWhere(@Param("where") String where);

	@Select("select Crm_revisit.* from  Crm_revisit ")
	public  List<Revisit> getAll();

	@Select("select Crm_revisit.* from Crm_revisit  where id=#{id}")
	public  Revisit getByid(Integer id);

	@Delete("delete from Crm_revisit where id=#{id}")
	public int delete(Integer id);

	 @Insert("insert into Crm_revisit (time,userid,cusid,ques,method,nextdateid,comments) values(#{time},#{userid},#{cusid},#{ques},#{method},#{nextdateid},#{comments})")
	 public Integer insert(Revisit t);

	 @Update("update Crm_revisit set time=#{time},userid=#{userid},cusid=#{cusid},ques=#{ques},method=#{method},nextdateid=#{nextdateid},comments=#{comments} where id=#{id}")
	 public Integer update(Revisit t);

}
