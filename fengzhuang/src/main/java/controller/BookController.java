package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Book;
import entity.Type;
import service.BookService;
import service.TypeService;
import utils.ReturnInfo;

@Controller
@RequestMapping("Book")
public class BookController extends BasicController<Book> {
	@Autowired
	BookService service;
	
	@Autowired
	TypeService tservice;
//	
//	
//	

	
	@Override
	public String index(ModelMap m,HttpServletRequest req) {
		String txt=req.getParameter("txt");
		String where=""; 
		if(txt!=null&&txt.length()>0) where=" where book.name like '%"+txt+"%' ";
		m.put("list", service.getWhere(where));
		return "Book/index";
	}

	
//	@GetMapping(value="Book")
//	public @ResponseBody ReturnInfo index2(String txt ,Integer page,Integer limit,ModelMap m) {
//		if(txt==null||txt.length()==0) txt="";
//		return basicservice.select(txt, page, limit);
//	}
	
	@RequestMapping("add")
	public String add(ModelMap m,HttpServletRequest req) {
		//m.put("sexs", Book.sexs);
		//m.put("typelist", tservice.getAll());
		return "Book/edit";
	}
//	@RequestMapping("edit")
//	public String edit(Integer id,ModelMap m,HttpServletRequest req) {
//		m.put("info", service.getByid(id));
//		return add(m,req);
//	}
	
	@RequestMapping("getSexs")
	public @ResponseBody String[] getSexs() {
		return Book.sexs;
	}
	
	@RequestMapping("getTypes")
	public @ResponseBody List<Type> getTypes() {
		return tservice.getAll();
	}

//	@DeleteMapping("{id}")//É¾³ý
//	public @ResponseBody String delete(@PathVariable Integer id,ModelMap m,HttpServletRequest req) {
//		basicservice.delete(id);
//		 return "{\"status\":1}";
//	}
}
