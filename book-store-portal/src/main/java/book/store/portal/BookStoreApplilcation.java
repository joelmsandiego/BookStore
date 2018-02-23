/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.store.portal;

import book.store.portal.route.AddBookRoute;
import book.store.portal.route.BookStoreDeleteRoute;
import book.store.portal.route.FilteredBookRoute;
import book.store.portal.route.ShowAllBooksRoute;
import book.store.portal.route.renameTagRoute;
import book.store.portal.tx.GsonTransformer;
import javax.ws.rs.core.MediaType;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import spark.servlet.SparkApplication;

/**
 *
 * @author joel
 */
public class BookStoreApplilcation implements SparkApplication{

    @Override
    public void init() {
        post("/ws/BookStore/FilteredBook", MediaType.APPLICATION_JSON, new FilteredBookRoute(), new GsonTransformer());
        post("/ws/BookStore/DeleteBook", MediaType.APPLICATION_JSON, new BookStoreDeleteRoute(), new GsonTransformer());
        post("/ws/BookStore/RenameBook", MediaType.APPLICATION_JSON, new renameTagRoute(), new GsonTransformer());
        post("/ws/BookStore/AddBook", MediaType.APPLICATION_JSON, new AddBookRoute(), new GsonTransformer());
        get("/ws/BookStore/ShowAllBooks", MediaType.APPLICATION_JSON, new ShowAllBooksRoute(), new GsonTransformer());
    }
    
}
