package controller;

import org.apache.shiro.authc.AccountException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import entity.User;
import entity.Userstatu;
import service.UserService;
import service.UserStatuService;

@Controller
@RequestMapping("User")
public class UserController extends BasicController<User>{
	@Autowired
	UserService service;
	
	@Autowired
	UserStatuService ustateservice;
	
	@RequestMapping("login")
	public String login(User u,String code,ModelMap m,HttpSession s) {
		//验证码
//		String num=s.getAttribute("number").toString();
//		if(!num.equalsIgnoreCase(code)) {
//			return "redirect:/login.html";
//		}
		
		
//		User user=service.login(u);
//		if(user!=null) {
//			s.setMaxInactiveInterval(10);
//			s.setAttribute("user", user);
//			return "redirect:/index.jsp";
//		}else {
//			return "redirect:/login.html";
//		}
		try {
			//SecurityUtils.getSubject().getSession().setTimeout();//设置超时时间
			SecurityUtils.getSubject().login(new UsernamePasswordToken(u.getUsername(),u.getUserpass()));
		}catch(AccountException e){
			return "redirect:/X-admin/login.html";
		}
		return "redirect:/X-admin/index.html";
	}
	
	@RequestMapping("outlogin")
	public String login(HttpSession s,HttpServletRequest req) {
		//s.removeAttribute("user");
		SecurityUtils.getSubject().logout();
		return "redirect:../login.html";
	}
	
	
	
	public String index(String name,ModelMap m) {
		String where=""; 
		if(name!=null&&name.length()>0) where=" where username like '%"+name+"%' ";
		m.put("list", service.getWhere(where));
		return "index";
	}
	
	@RequestMapping("getStatus")
	public @ResponseBody List<Userstatu> getTypes() {
		return ustateservice.getAll();
	}
	
	
}
