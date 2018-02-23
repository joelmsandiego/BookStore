/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */

package book.store.portal.route;


import book.store.cons.BookData;
import book.store.enums.ServiceStatus;
import book.store.portal.client.BookStoreClient;
import book.store.resp.DefaultListResp;
import book.store.resp.DefaultResp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.math.BigInteger;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @since June 21, 2016
 */
public class BookStoreDeleteRoute implements Route {
    private static final Logger LOG = LoggerFactory.getLogger(BookStoreDeleteRoute.class);
    private Gson gson;
    public BookStoreDeleteRoute() {
        gson = (new GsonBuilder()).create();
    }
    @Override
    public Object handle(Request rqst, Response rspns) throws Exception {
        BookData data = gson.fromJson(rqst.body(), BookData.class);      
        BookStoreClient client = new BookStoreClient();
        DefaultResp respd = client.deleteBook(data);
        client.close();
        rspns.header("Content-Type", MediaType.APPLICATION_JSON);
        return respd;
//        LOG.debug("Executing handler for DELETE ROUTE operation for Bookstore.");
//        String id = (rqst.splat() != null && rqst.splat().length > 0) ? rqst.splat()[0] : "";
//        BookData data = new BookData();
//        data.setBookId(new BigInteger(id));
//        try{
//        rspns.header("Content-Type", MediaType.APPLICATION_JSON);
//        if(id != null && id.trim().isEmpty() == false && id.matches("^\\d+$")) {
//            BookStoreClient client = new BookStoreClient();
//            DefaultResp respd = client.deleteBook(id);
//            client.close();
//            return respd;
//        } else {
//            return new DefaultResp(ServiceStatus.ERROR, "Invalid ID Argument");
//        }
//        }catch(Throwable t){
//            LOG.debug("Error in route! "+t.getLocalizedMessage());
//            return new DefaultResp(ServiceStatus.ERROR, "Invalid ID Argument");
//        }
    }

}
