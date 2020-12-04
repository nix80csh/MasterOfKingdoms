package com.mok.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.orm.jpa.JpaSystemException;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
	private EntityManager em;

	private final Class<T> entityType;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		entityType = (Class<T>) pt.getActualTypeArguments()[0];
	}

	public T readById(int id) {
		return em.find(entityType, id);
	}

	public T create(T entity) {
		em.persist(entity);
		return entity;
	}

	public T update(T entity) {
		return em.merge(entity);
	}

	public void delete(T entity) {
		em.remove(entity);
	}

}
