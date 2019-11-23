package com.wky.oa.service.impl;


import javax.annotation.Resource;

import com.wky.oa.dao.IBookDao;
import com.wky.oa.domain.Book;
import com.wky.oa.service.IBookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements IBookService {
	
	@Resource
	private IBookDao bookDao;

	public void delete(Long id) {
		// TODO Auto-generated method stub
		bookDao.delete(id);
	}


	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookDao.findAll();
	}


	public Book getById(Long id) {
		// TODO Auto-generated method stub
		return bookDao.getById(id);
	}


	public List<Book> getByIds(Long[] ids) {
		// TODO Auto-generated method stub
		return bookDao.getByIds(ids);
	}


	public void save(Book book) {
		// TODO Auto-generated method stub
		bookDao.save(book);
	}


	public void update(Book book) {
		// TODO Auto-generated method stub
		bookDao.update(book);
	}


}
