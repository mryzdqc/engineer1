package service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserStatuDao;
import entity.Userstatu;
import service.UserStatuService;

@Service
public class UserStatuServiceImpl extends BasicServiceImpl<Userstatu> implements  UserStatuService{
@Autowired
UserStatuDao dao;



}
