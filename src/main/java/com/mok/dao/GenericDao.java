package com.mok.dao;


public interface GenericDao<T> {	
	T readById(int id);
    T create(T type);
    T update(T type);
    void delete(T type);   
}
