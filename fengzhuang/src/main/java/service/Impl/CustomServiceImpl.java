package service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomDao;
import entity.Custom;
import service.CustomService;
import utils.ReturnInfo;

@Service
public class CustomServiceImpl extends BasicServiceImpl<Custom> implements CustomService{
	@Autowired
	CustomDao dao;
	
	public ReturnInfo select(String txt, Integer page, Integer limit) {
		if(txt==null||txt.length()==0) txt="";
		else txt="where cusname like '%"+txt+"%'";
		ReturnInfo info = new ReturnInfo();
		String limitstr="";
		if(page!=null) {
			limitstr="limit "+((page-1)*limit)+","+limit;
			Integer cnt = dao.selectCount(txt);
			info.setCount(cnt);
		}
		List<Custom> list;
		list = dao.select(txt, limitstr);
		
		info.setList(list);
		return info;
	}
}
