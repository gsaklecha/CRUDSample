package com.sample.demo.repository;

import java.io.Serializable;
import java.util.List;

import com.sample.demo.exception.RecordNotFoundException;

public interface IGenericDao<T extends Serializable> {
	
	/**
	 * @description method to set entity class
	 * @param clazzToSet
	 */
	public void setClazz(Class<T> clazzToSet);

	/**
	 * @description method to find all record of entity from database
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * @description method to find record by id
	 * @param id
	 * @return
	 * @throws RecordNotFoundException
	 */
	public T findById(Long id) throws RecordNotFoundException;
	
	/**
	 * @description method to find record by version id
	 * @param versionId
	 * @return
	 * @throws RecordNotFoundException
	 */
	public T findByVersionId(String versionId) throws RecordNotFoundException;
	
	/**
	 * @description method to save record in database
	 * @param newEntity
	 * @return
	 */
	public T save(Object object);
	
	/**
	 * @description method to update record in database
	 * @param newEntity
	 * @return
	 */
	public T update(Object object);
	
	/**
	 * @description method to remove record from database
	 * @param book
	 */
	public void deleteEntity(Object object);
}
