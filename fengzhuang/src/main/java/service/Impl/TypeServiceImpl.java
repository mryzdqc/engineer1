package service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TypeDao;
import entity.Type;
import service.TypeService;

@Service
public class TypeServiceImpl extends BasicServiceImpl<Type> implements  TypeService{
@Autowired
TypeDao dao;



}
