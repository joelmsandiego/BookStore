/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */

package book.store.portal.route;

import book.store.cons.FilterData;
import book.store.portal.client.BookStoreClient;
import book.store.resp.BookStoreListResp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.MediaType;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 */
public class FilteredBookRoute implements Route {
    private final Gson gson;
    
    public FilteredBookRoute() {
        gson = (new GsonBuilder()).create();
    }
    
    @Override
    public Object handle(Request rqst, Response rspns) throws Exception {
        FilterData data = gson.fromJson(rqst.body(), FilterData.class);
        BookStoreClient client = new BookStoreClient();
        BookStoreListResp respd = client.filterByData(data);
        client.close();
        rspns.header("Content-Type", MediaType.APPLICATION_JSON);
        return respd;
    }
}
