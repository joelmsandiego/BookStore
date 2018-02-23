
import book.store.cons.BookData;
import book.store.cons.FilterData;
import book.store.services.ws.BookStoreResources;
import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joel
 */
public class BookStoreTest {
    
    public static void main(String args[]){
        BookStoreResources ws = new BookStoreResources();
//        BookData data = new BookData();
        FilterData data = new FilterData();
        //done save
        //done by date
        //done by price
        //done by author
        //fetch all
        
//        data.setBookAuthor("RougeRougeRouge");
//        data.setBookGenre("Adventure 3nd");
//        data.setBookId(new BigInteger("4"));
//        data.setBookTittle("hello bite");
//        data.setCreatedBy("joel");
//        data.setPrice(500);
//        data.setCreatedDate("2018-02-22");

//        data.setAuthor("joel2");
//        data.setDate("2018-02-22");
//        data.setGenre("Journey The 3nd");
//        data.setLimitBy(5);
//        data.setPrice(500);
        data.setTittle("hello bites");
        ws.filterByData(data);
    }
}
