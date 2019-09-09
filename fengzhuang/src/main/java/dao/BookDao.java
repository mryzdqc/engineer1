package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Book;
@Repository
public interface BookDao {
	
	@Select("select count(1) from Book inner join Type on Book.typeid=Type.id ${name}")
	public int selectCount(@Param("name") String name);
	
		@Select("select Book.*,type.name typename from  Book inner join type on book.typeid=type.id   ${where} ")
		public  List<Book> getWhere(@Param("where") String where);

		@Select("select Book.* from  Book ")
		public  List<Book> getAll();

		@Select("select Book.* from Book  where id=#{id}")
		public  Book getByid(@Param("id")Integer id);

		@Delete("delete from Book where id=#{id}")
		public int delete(@Param("id")Integer id);

		 @Insert("insert into Book (name,sex,typeid) values(#{name},#{sex},#{typeid})")
		 public Integer insert(Book t);

		 @Update("update Book set name=#{name},sex=#{sex},typeid=#{typeid} where id=#{id}")
		 public Integer update(Book t);
		 
		 @Select("select Book.*,type.name typename from Book inner join Type on Book.typeid=Type.id ${name} ${limit}")
		 public List<Book> select(@Param("name") String name,@Param("limit") String limit);

	}

