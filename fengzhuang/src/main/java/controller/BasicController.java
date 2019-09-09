package controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Book;
import entity.Type;
import service.TypeService;
import service.basicService;
import service.Impl.BasicServiceImpl;
import utils.ReturnInfo;


public class BasicController<T>  {
	
	BasicServiceImpl<T> basicservice;
	
	@ModelAttribute
	public void init() throws Exception{
		Field f=this.getClass().getDeclaredField("service");
		f.setAccessible(true);
		Object dao=f.get(this);
		basicservice=(BasicServiceImpl<T>) dao;
	}
	
	private String getTname() {
		return getRealType().getSimpleName();
	}
	
	public Class getRealType(){
		// 获取当前new的对象的泛型的父类类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获取第一个类型参数的真实类型
		return (Class<T>) pt.getActualTypeArguments()[0];
	}
	
	
	@GetMapping("index")
	public String index(ModelMap m,HttpServletRequest req) {
		//m.put("list", basicservice.getWhere(""));
		return getTname()+"/index";
	}
	

	
	@GetMapping()
	public @ResponseBody ReturnInfo index2(String txt ,Integer page,Integer limit,ModelMap m) {
		if(txt==null||txt.length()==0) txt="";
		return basicservice.select(txt, page, limit);
	}
	
	
	@GetMapping("{id}")
	public @ResponseBody T edit(@PathVariable Integer id,ModelMap m) {
		return basicservice.getByid(id);
	}
	@RequestMapping("edit0")
	public String edit0(ModelMap m) {//中转请求参数
		
		return getTname()+"/edit";
	}
	
	@DeleteMapping("{id}")//删除
	public @ResponseBody String delete(@PathVariable Integer id,ModelMap m,HttpServletRequest req) {
		basicservice.delete(id);
		 return "{\"status\":1}";
	}
	
	@RequestMapping("add")
	public String add(ModelMap m,HttpServletRequest req) {
		return getTname()+"/edit";
	}
//	@RequestMapping("edit")
//	public String edit(Integer id,ModelMap m,HttpServletRequest req) {
//		m.put("info", basicservice.getByid(id));
//		return add( m,req);
//	}
	
	@PostMapping()//新增
	public @ResponseBody String insert(  T t,ModelMap m,HttpServletRequest req) {
		basicservice.insert(t);
		return "{\"status\":1}";
	}
	@PutMapping("{id}")//修改
	public @ResponseBody String update(T t,ModelMap m,HttpServletRequest req) {
		basicservice.update(t);
		return "{\"status\":1}";
	}
}
