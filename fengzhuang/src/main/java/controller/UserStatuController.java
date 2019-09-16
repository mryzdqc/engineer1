package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Userstatu;
import service.UserStatuService;

@Controller
@RequestMapping("Userstatu")
public class UserStatuController extends BasicController<Userstatu> {
	@Autowired
	UserStatuService service;
	
}
