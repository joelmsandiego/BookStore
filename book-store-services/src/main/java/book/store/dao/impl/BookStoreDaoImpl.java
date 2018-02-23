/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.store.dao.impl;

import book.store.dao.BookStoreDao;
import book.store.entity.BookStoreEntity;
import com.google.gson.Gson;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author joel
 */
public class BookStoreDaoImpl extends CommonDaoImpl<BookStoreEntity,BigInteger> 
             implements BookStoreDao{
    private static final Logger LOG = LoggerFactory.getLogger(BookStoreDaoImpl.class);
    private List<BookStoreEntity> entity = new ArrayList<BookStoreEntity>();
    private Gson gson = new Gson();
    public BookStoreDaoImpl(EntityManager em) {
        super(BookStoreEntity.class, em);
    }

    @Override
    public List<BookStoreEntity> getAllBooks() {
        LOG.debug("Executing getAllBooks...");
        try{
            Query query = getEntityManager().createNamedQuery("GET_BOOK");
            entity = (List<BookStoreEntity>) query.getResultList();
            if(entity.size()>0){
                LOG.debug("Result found!");
            }else{
                LOG.debug("no data found!");
            }
        }catch(Throwable t){
            LOG.debug("Error in dao impl! "+t.getLocalizedMessage());
        }
        return entity;
    }

    @Override
    public List<BookStoreEntity> getAllBooksbyDate(String date) {
         LOG.debug("Executing getAllBooksbyDate...");
        try{
            Query query = getEntityManager().createNamedQuery("GET_BOOK_BY_DATE");
            query.setParameter("date", date);
            entity = (List<BookStoreEntity>) query.getResultList();
            if(entity.size()>0){
                LOG.debug("Result found!");
            }else{
                LOG.debug("no data found!");
            }
        }catch(Throwable t){
            LOG.debug("Error in dao impl! "+t.getLocalizedMessage());
        }
        return entity;
    }

    @Override
    public List<BookStoreEntity> getAllBooksbyPrice(double price) {
     LOG.debug("Executing getAllBooksbyPrice...");
        try{
            Query query = getEntityManager().createNamedQuery("GET_BOOK_BY_PRICE");
            query.setParameter("price", price);
            entity = (List<BookStoreEntity>) query.getResultList();
            if(entity.size()>0){
                LOG.debug("Result found!");
            }else{
                LOG.debug("no data found!");
            }
        }catch(Throwable t){
            LOG.debug("Error in dao impl! "+t.getLocalizedMessage());
        }
        return entity;
    }

    @Override
    public List<BookStoreEntity> getAllBooksbyTittle(String tittle) {
         LOG.debug("Executing getAllBooksbyTittle...");
        try{
            Query query = getEntityManager().createNamedQuery("GET_BOOK_BY_TITLLE");
            query.setParameter("tittle", tittle);
            entity = (List<BookStoreEntity>) query.getResultList();
            if(entity.size()>0){
                LOG.debug("Result found!");
            }else{
                LOG.debug("no data found!");
            }
        }catch(Throwable t){
            LOG.debug("Error in dao impl! "+t.getLocalizedMessage());
        }
        return entity;
    }

    @Override
    public List<BookStoreEntity> getAllBooksbyAuthor(String author) {
         LOG.debug("Executing getAllBooksbyAuthor...");
        try{
            Query query = getEntityManager().createNamedQuery("GET_BOOK_BY_AUTHOR");
            query.setParameter("author", author);
            entity = (List<BookStoreEntity>) query.getResultList();
            if(entity.size()>0){
                LOG.debug("Result found!");
            }else{
                LOG.debug("no data found!");
            }
        }catch(Throwable t){
            LOG.debug("Error in dao impl! "+t.getLocalizedMessage());
        }
        return entity;
    }
    @Override
    public List<BookStoreEntity> getAllBooksbyGenre(String genre) {
         LOG.debug("Executing getAllBooksbyGenre...");
        try{
            Query query = getEntityManager().createNamedQuery("GET_BOOK_BY_GENRE");
            query.setParameter("genre", genre);
            entity = (List<BookStoreEntity>) query.getResultList();
            if(entity.size()>0){
                LOG.debug("Result found!");
            }else{
                LOG.debug("no data found!");
            }
        }catch(Throwable t){
            LOG.debug("Error in dao impl! "+t.getLocalizedMessage());
        }
        return entity;
    }
    
}
