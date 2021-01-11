package com.lti.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GenericDao {	
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Transactional
	public Object save(Object obj) {
			Object updatedObj = entityManager.merge(obj);
			return updatedObj;
	}


	public <E> E fetchByKey(Class<E> clazz, Object pk) {
			E e = entityManager.find(clazz, pk);
			return e;
	}
	


}




