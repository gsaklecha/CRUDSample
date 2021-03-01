package com.sample.demo.service;

import java.util.List;

import com.sample.demo.exception.PersistException;
import com.sample.demo.exception.RecordNotFoundException;
import com.sample.demo.exception.StateNotMatchException;
import com.sample.demo.model.BookEntity;

/**
 * Service layer
 * @author qe3nrt
 *
 */
public interface IBookService {
	
	/**
	 * @description Method to get all the books
	 * @return
	 */
	public List<BookEntity> getAllBooks();
	
	/**
	 * @description method to get book by id 
	 * @param id
	 * @return
	 * @throws RecordNotFoundException
	 */
	public BookEntity getBookById(Long id) throws RecordNotFoundException;
	
	/**
	 * @description method to insert book into the database
	 * @param entity
	 * @return
	 * @throws PersistException
	 */
	public BookEntity createBook(BookEntity entity) throws PersistException;
	
	/**
	 * @description method to update book into the database
	 * @param entity
	 * @return
	 * @throws StateNotMatchException
	 * @throws PersistException
	 */
	public BookEntity updateBook(BookEntity entity) throws StateNotMatchException, PersistException;
	
	/**
	 * @description method to delete book by version id
	 * @param versionId
	 * @throws StateNotMatchException
	 */
	public void deleteBookByVersionId(String versionId) throws StateNotMatchException;

}
