package com.sample.demo.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.sample.demo.exception.RecordNotFoundException;
import com.sample.demo.repository.IGenericDao;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@SuppressWarnings("unchecked")
public class GenericJpaDao<T extends Serializable> implements IGenericDao<T> {

	private Class<T> clazz;

	public void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<T> findAll() {
		return entityManager.createNamedQuery("query_find_all_books", clazz).getResultList();
	}

	
	@Override
	public T findById(Long id) throws RecordNotFoundException {
		Object object = entityManager.find(clazz, id);
		if (object == null) {
			throw new RecordNotFoundException("Can't find book for ID " + id);
		}
		return (T) object;
	}
	
	@Override
	public T findByVersionId(String versionId) throws RecordNotFoundException  {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cr = cb.createQuery(clazz);
		Root<T> root = cr.from(clazz);
		cr.select(root).where(cb.equal(root.get("versionId"), versionId));
		Query query = entityManager.createQuery(cr);
		List<T> results = query.getResultList();
		if(results.size() > 0) {
			return (T) results.get(0);
		} else {
			 throw new RecordNotFoundException("Can't find book for versionId "
		                + versionId);
		}
	}

	@Override
	public T save(Object object) {
		entityManager.persist(object);
		return (T) object;
	}

	@Override
	public T update(Object object) {
		entityManager.persist(object);
		return (T) object;
	}

	@Override
	public void deleteEntity(Object object) {
		entityManager.remove(object);
	}

}