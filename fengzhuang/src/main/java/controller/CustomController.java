package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import entity.Custom;
import entity.Type;

import service.CustomService;

@Controller
@RequestMapping("Custom")
public class CustomController extends BasicController<Custom> {
	@Autowired
	CustomService service;
	
	
	@RequestMapping("getSexs")
	public @ResponseBody String[] getSexs() {
		return Custom.sexs;
	}
	
	@RequestMapping("getAssignStates")
	public @ResponseBody String[] getTypes() {
		return Custom.asstate;
	}
	
	@RequestMapping("getSelfStates")
	public @ResponseBody String[] getTypes2() {
		return Custom.selstate;
	}
	
}
