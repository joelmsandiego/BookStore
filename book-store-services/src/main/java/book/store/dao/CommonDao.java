/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.store.dao;

import book.store.dao.exception.DaoException;

/**
 *
 * @author joel
 */
public interface CommonDao <ENTITYTYPE,IDTYPE>{
    ENTITYTYPE findById(IDTYPE ID) throws DaoException;
    void save(final ENTITYTYPE entity) throws DaoException;
    void update(final ENTITYTYPE entity) throws DaoException;
    void softDelete(final ENTITYTYPE entity) throws DaoException;
    void hardDelete(final ENTITYTYPE entity) throws DaoException;
    void close();
}
