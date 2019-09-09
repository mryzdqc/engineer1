package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Type;
import service.TypeService;

@Controller
@RequestMapping("Type")
public class TypeController extends BasicController<Type> {
	@Autowired
	TypeService service;
	
}
