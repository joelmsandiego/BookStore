/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.store.daoutils;

import book.store.dao.DatabaseDaoFactory;
import book.store.dao.impl.DatabaseDaoFactoryImpl;
import javax.persistence.Persistence;

/**
 *
 * @author Jeric
 */
public abstract class DaoUtils {

    private static final DatabaseDaoFactory DBDAOFACTORY;
    
    static {
        try {                                                                                //name in persistence unit
            DBDAOFACTORY = new DatabaseDaoFactoryImpl(Persistence.createEntityManagerFactory("Joel"));
        } catch (Throwable t) {
            throw new ExceptionInInitializerError(t);
        }
    }
    
    public static DatabaseDaoFactory getDatabaseDaoFactory() {
        return DBDAOFACTORY;
    }
    
}
