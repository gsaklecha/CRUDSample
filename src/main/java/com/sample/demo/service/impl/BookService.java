package com.sample.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.exception.PersistException;
import com.sample.demo.exception.RecordNotFoundException;
import com.sample.demo.exception.StateNotMatchException;
import com.sample.demo.model.BookEntity;
import com.sample.demo.repository.IGenericDao;
import com.sample.demo.service.IBookService;

@Service
@Transactional
public class BookService implements IBookService {

	IGenericDao<BookEntity> bookDao;
	
	@Autowired
	public void setDao(IGenericDao<BookEntity> daoToSet) {
		bookDao = daoToSet;
		bookDao.setClazz(BookEntity.class);
	}

	public List<BookEntity> getAllBooks() {
		List<BookEntity> bookList = bookDao.findAll();

		if (bookList.size() > 0) {
			return bookList;
		} else {
			return new ArrayList<BookEntity>();
		}
	}

	public BookEntity getBookById(Long id) throws RecordNotFoundException {
		return bookDao.findById(id);
	}

	public BookEntity createBook(BookEntity entity) throws PersistException {
		try {
			entity.setVersionId(UUID.randomUUID().toString());
			return bookDao.save(entity);
		} catch (Exception ex) {
			throw new PersistException("Failed to save record");
		}
	}
	
	public BookEntity updateBook(BookEntity entity) throws StateNotMatchException, PersistException {
		try {
			// check state of entity
			BookEntity book = bookDao.findByVersionId(entity.getVersionId());
			book.setBookName(entity.getBookName());
			book.setAuthor(entity.getAuthor());
			book.setBookContent(entity.getBookContent());
			book.setVersionId(UUID.randomUUID().toString());
			book = bookDao.update(book);
			return book;
		} catch (RecordNotFoundException ex) {
			throw new StateNotMatchException("No book record exist for given versionId");
		} catch (Exception e) {
			throw new PersistException("Failed to update record");
		}
	}

	public void deleteBookByVersionId(String versionId) throws StateNotMatchException {
		try {
			// check state of entity
			BookEntity book = bookDao.findByVersionId(versionId);
			bookDao.deleteEntity(book);
		} catch (RecordNotFoundException ex) {
			throw new StateNotMatchException("No book record exist for given versionId");
		}
	}

}