package service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BookDao;
import entity.Book;
import service.BookService;

@Service
public class BookServiceImpl extends BasicServiceImpl<Book> implements BookService{
	@Autowired
	BookDao dao;
	
	
}
