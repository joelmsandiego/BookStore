/*
 * All Rights Reserved
 */

package book.store.portal.client;


import book.store.cons.BookData;
import book.store.cons.FilterData;
import book.store.enums.ServiceStatus;
import book.store.portal.webservice.client.BaseClient;
import book.store.resp.BookStoreListResp;
import book.store.resp.DefaultResp;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * </p>
 * 
 */
public class BookStoreClient extends BaseClient {
    private static final Logger LOG = LoggerFactory.getLogger(BookStoreClient.class);
    private static final String PATH = "BookStore/";
    private Gson gson = new Gson();
    public BookStoreListResp showAllBooks(){
        BookStoreListResp resp = null;
        BookData data = new BookData();
        List<BookData> allData = new ArrayList<BookData>();
        LOG.debug("Executing GET operation for showAllBooks Web Service.");
        try {
            WebTarget targ = createTarget(PATH+"ShowAllBooks");
            LOG.debug("PATH: '{}'", targ.getUri().toString());
            resp = targ.request(MediaType.APPLICATION_JSON).get(BookStoreListResp.class);
//            String payload = targ.request(MediaType.APPLICATION_JSON).get(String.class);
//            data = gson.fromJson(payload, BookData.class);
//            allData.add(data);
//            resp = new DefaultListResp(allData,ServiceStatus.SUCCESS,"");
            LOG.debug("result"+gson.toJson(resp));
            
        } catch(Throwable t) {
            resp = new BookStoreListResp(ServiceStatus.ERROR, "Error in showAllBooks: "+t.getMessage());
        }
        return resp;
    }
    
    public DefaultResp<BookData> renameTag(BookData data){
        LOG.debug("Executing rename tag operation for Web Service.");
        DefaultResp retval = null;
        try {
            WebTarget targ = createTarget(PATH+"RenameTag");
            retval = targ.request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(data, MediaType.APPLICATION_JSON), 
                            DefaultResp.class);
            LOG.debug("Successful request! "+gson.toJson(retval));
        } catch(Throwable t) {
            retval = new DefaultResp(ServiceStatus.ERROR, t.getMessage());
        }
        return retval;
    }
    
    public DefaultResp<BookData> deleteBook(BookData  data){
        LOG.debug("Executing DeleteBook operation for delete books Web Service. " +gson.toJson(data));
        DefaultResp retval =null;
        try {
            WebTarget targ = createTarget(PATH+"DeleteBook");
            retval = targ.request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(data, MediaType.APPLICATION_JSON), 
                            DefaultResp.class);
        } catch(Throwable t) {
            retval = new DefaultResp(ServiceStatus.ERROR, "Error: "+t.getLocalizedMessage());
        }
        return retval;
    }
    
    public DefaultResp<BookData> save(BookData data){
        LOG.debug("Executing POST operation for save Web Service.");
        DefaultResp retval = null;
        try {
            WebTarget targ = createTarget(PATH+"AddBooks");
            retval= targ.request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(data, MediaType.APPLICATION_JSON), 
                            DefaultResp.class);
        } catch(Throwable t) {
            retval = new DefaultResp(ServiceStatus.ERROR, t.getMessage());
        }
        return retval;
    }
    public BookStoreListResp filterByData(FilterData data){
        LOG.debug("Executing POST operation for filtered data Web Service.");
        BookStoreListResp retval = null;
        try {
            WebTarget targ = createTarget(PATH+"FilterByData");
            retval= targ.request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(data, MediaType.APPLICATION_JSON), 
                            BookStoreListResp.class);
            LOG.debug("result found! "+gson.toJson(retval));
        } catch(Throwable t) {
            retval = new BookStoreListResp(ServiceStatus.ERROR, t.getMessage());
        }
        return retval;
    } 
}
