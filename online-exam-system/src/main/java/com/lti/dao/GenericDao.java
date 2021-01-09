package com.lti.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


//@Repository //recommended for classes which interacts with DB

public class GenericDao {	
	
	@PersistenceContext
	protected EntityManager entityManager;
	

	public Object save(Object obj) {
			Object updatedObj = entityManager.merge(obj);
			return updatedObj;
	}


	public <E> E fetchByKey(Class<E> clazz, Object pk) {
			E e = entityManager.find(clazz, pk);
			return e;
	}
	


}




