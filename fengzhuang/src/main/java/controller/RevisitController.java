package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Revisit;
import service.RevisitService;

@Controller
@RequestMapping("Revisit")
public class RevisitController extends BasicController<Revisit> {
	@Autowired
	RevisitService service;
	
}
