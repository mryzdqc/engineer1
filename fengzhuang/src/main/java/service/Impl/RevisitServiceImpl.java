package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RevisitDao;

import entity.Revisit;
import service.RevisitService;
import utils.ReturnInfo;

@Service
public class RevisitServiceImpl extends BasicServiceImpl<Revisit> implements  RevisitService{
@Autowired
RevisitDao dao;

public ReturnInfo select(String txt, Integer page, Integer limit) {
	if(txt==null||txt.length()==0) txt="";
	else txt="where crm_operator.username like '%"+txt+"%'";
	ReturnInfo info = new ReturnInfo();
	String limitstr="";
	if(page!=null) {
		limitstr="limit "+((page-1)*limit)+","+limit;
		Integer cnt = dao.selectCount(txt);
		info.setCount(cnt);
	}
	List<Revisit> list;
	list = dao.select(txt, limitstr);
	
	info.setList(list);
	return info;
}

}
