/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */

package book.store.portal.route;


import book.store.portal.client.BookStoreClient;
import book.store.resp.BookStoreListResp;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 */
public class ShowAllBooksRoute implements Route {
    private static final Logger LOG = LoggerFactory.getLogger(ShowAllBooksRoute.class);
    
    @Override
    public Object handle(Request rqst, Response rspns) throws Exception {
        LOG.debug("Executing handler for GET ROUTE operation for Book Store.");
        BookStoreClient client = new BookStoreClient();
        BookStoreListResp respd = client.showAllBooks();
        client.close();
        rspns.header("Content-Type", MediaType.APPLICATION_JSON);
        return respd;
    }

}
