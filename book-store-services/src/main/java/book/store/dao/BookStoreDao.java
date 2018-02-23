/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.store.dao;

import book.store.entity.BookStoreEntity;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author joel
 */
public interface BookStoreDao extends CommonDao<BookStoreEntity,BigInteger>{
    List<BookStoreEntity> getAllBooks();
    List<BookStoreEntity> getAllBooksbyDate(String date);
    List<BookStoreEntity> getAllBooksbyPrice(double price);
    List<BookStoreEntity> getAllBooksbyTittle(String tittle);
    List<BookStoreEntity> getAllBooksbyAuthor(String author);
    List<BookStoreEntity> getAllBooksbyGenre(String genre);
    
    
}
