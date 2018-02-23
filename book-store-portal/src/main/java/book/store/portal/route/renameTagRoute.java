/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */

package book.store.portal.route;

import book.store.cons.BookData;
import book.store.portal.client.BookStoreClient;
import book.store.resp.DefaultResp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.MediaType;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 */
public class renameTagRoute implements Route {
    private final Gson gson;
    
    public renameTagRoute() {
        gson = (new GsonBuilder()).create();
    }
    
    @Override
    public Object handle(Request rqst, Response rspns) throws Exception {
        BookData data = gson.fromJson(rqst.body(), BookData.class);
        BookStoreClient client = new BookStoreClient();
        DefaultResp respd = client.renameTag(data);
        client.close();
        rspns.header("Content-Type", MediaType.APPLICATION_JSON);
        return respd;
    }
}
