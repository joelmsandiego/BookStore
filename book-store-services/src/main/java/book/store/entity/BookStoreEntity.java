/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.store.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author joel
 */
@Entity
@Table(name="book_info")
@NamedQueries(value={
    @NamedQuery(name="GET_BOOK",
            query="FROM BookStoreEntity ORDER by bookId ASC"),
    @NamedQuery(name="GET_BOOK_BY_DATE",
            query="FROM BookStoreEntity WHERE createdDate =:date"),
    @NamedQuery(name="GET_BOOK_BY_PRICE",
            query="FROM BookStoreEntity WHERE price =:price"),
    @NamedQuery(name="GET_BOOK_BY_TITLLE",
            query="FROM BookStoreEntity WHERE bookTittle =:tittle"),
    @NamedQuery(name="GET_BOOK_BY_AUTHOR",
            query="FROM BookStoreEntity bs WHERE bs.bookAuthor =:author"),
    @NamedQuery(name="GET_BOOK_BY_GENRE",
            query="FROM BookStoreEntity WHERE bookGenre =:genre")
    
})
public class BookStoreEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="book_id")
    private BigInteger bookId;
    
    @Column(name="book_tittle")
    private String bookTittle;
    
    @Column(name="book_author")
    private String bookAuthor;
    
    @Column(name="book_genre")
    private String bookGenre;
    
    @Column(name="price")
    private double price;
    
    @Column(name="created_by")
    private String createdBy;
    
    @Column(name="created_date")
    private String createdDate;
    
    @Column(name="last_modified_by")
    private String lastModBy;
    
    @Column(name="last_modified_date")
    private String lastModDate;
    
    public BookStoreEntity() {
    }

    public BigInteger getBookId() {
        return bookId;
    }

    public void setBookId(BigInteger bookId) {
        this.bookId = bookId;
    }

    public String getBookTittle() {
        return bookTittle;
    }

    public void setBookTittle(String bookTittle) {
        this.bookTittle = bookTittle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastModDate() {
        return lastModDate;
    }

    public void setLastModDate(String lastModDate) {
        this.lastModDate = lastModDate;
    }

}
