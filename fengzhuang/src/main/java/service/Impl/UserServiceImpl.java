package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;

import entity.User;
import service.UserService;
import utils.ReturnInfo;

@Service
public class UserServiceImpl extends BasicServiceImpl<User> implements  UserService{
@Autowired
UserDao dao;

public User login(User u) {
	return dao.login(u);
}

public ReturnInfo select(String txt, Integer page, Integer limit) {
	if(txt==null||txt.length()==0) txt="";
	else txt="where username like '%"+txt+"%'";
	ReturnInfo info = new ReturnInfo();
	String limitstr="";
	if(page!=null) {
		limitstr="limit "+((page-1)*limit)+","+limit;
		Integer cnt = dao.selectCount(txt);
		info.setCount(cnt);
	}
	List<User> list;
	list = dao.select(txt, limitstr);
	
	info.setList(list);
	return info;
}


}
