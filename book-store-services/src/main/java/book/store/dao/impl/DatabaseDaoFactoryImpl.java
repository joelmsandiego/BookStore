/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.store.dao.impl;

import book.store.dao.BookStoreDao;
import book.store.dao.DatabaseDaoFactory;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author joel
 */
public class DatabaseDaoFactoryImpl implements DatabaseDaoFactory{
    private final EntityManagerFactory emf;

    public DatabaseDaoFactoryImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public BookStoreDao getBookStoreDao() {
        return new BookStoreDaoImpl(emf.createEntityManager());
    }

}
