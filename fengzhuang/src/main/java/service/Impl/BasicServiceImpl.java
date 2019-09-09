package service.Impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.BookDao;
import entity.Book;
import entity.Type;
import service.BookService;
import service.basicService;
import utils.ReturnInfo;


public class BasicServiceImpl<T> implements basicService<T>{


private Object execDao(String mname,Object... objs){
	try {
	Field f=this.getClass().getDeclaredField("dao");
	f.setAccessible(true);
	Object dao=f.get(this);
		
	Class cls=dao.getClass();  //  daoµÄ×Ö½ÚÂë
	Class[] cs=new Class[objs.length];
	for(int i=0;i<objs.length;i++)cs[i]=objs[i].getClass();
	Method m= cls.getMethod(mname, cs);
	m.setAccessible(true);
	return m.invoke(dao, objs);
	}catch (Exception e) {
		e .printStackTrace();
		return null;
	}
	
}

public List<T> getWhere(String where) {
	Object o=execDao("getWhere", where);
	if(o!=null) return (List<T>) o;
	else return new ArrayList<T>();
}

public List<T> getAll() {
	Object o=execDao("getAll");
	if(o!=null) return (List<T>) o;
	else return new ArrayList<T>();
}

public T getByid(Integer id) {
	Object o=execDao("getByid",id);
	if(o!=null) return (T) o;
	else return null;
}

public int delete(Integer id) {
	Object o=execDao("delete",id);
	if(o!=null) return (Integer) o;
	else return -2;
}

public Integer insert(T t) {
	Object o=execDao("insert",t);
	if(o!=null) return (Integer) o;
	else return -2;
}

public Integer update(T t) {
	Object o=execDao("update",t);
	if(o!=null) return (Integer) o;
	else return -2;
}

public ReturnInfo select(String txt, Integer page, Integer limit) {
	if(txt==null||txt.length()==0) txt="";
	else txt="where book.name like '%"+txt+"%'";
	ReturnInfo info = new ReturnInfo();
	String limitstr="";
	if(page!=null) {
		limitstr="limit "+((page-1)*limit)+","+limit;
		Object o1=execDao("selectCount",txt);
		//System.out.println((Integer) o1);
		info.setCount((Integer) o1);
	}
	List<T> list;
	Object o=execDao("select", txt,limitstr);
	if(o!=null) list = (List<T>) o;
	else list = new ArrayList<T>();
	
	info.setList(list);
	return info;
}


}
