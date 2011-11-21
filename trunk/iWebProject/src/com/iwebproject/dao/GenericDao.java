package com.iwebproject.dao;

import java.io.Serializable;

public interface GenericDao<T,PK extends Serializable> {
	/**
	 * Persist the newInstance object into database
	 * @param newInstance
	 */
    void create(T newInstance);

    /**
     * Retrieve an object that was previously persisted to the database using
     * the indicated id as primary key
     * @param id
     * @return
     */
    T read(PK id);
    
    /**
     * Retrieve an object that was previously persisted to the database using
     * Object Model
     * @param id
     * @return
     */
    T read(T model);

    /**
     * Save changes made to a persistent object
     * @param transientObject
     */
    void update(T transientObject);

	/**
	 * Remove an object from persistent storage in the database
	 * @param persistentObject
	 */
    void delete(T persistentObject);
    
}
