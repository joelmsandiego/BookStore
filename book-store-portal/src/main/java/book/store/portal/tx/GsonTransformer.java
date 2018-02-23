/*
 * All Rights Reserved
 */

package book.store.portal.tx;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.ResponseTransformer;

/**
 * <p>
 * Responsible for transforming data into JSON format.
 * </p>
 * 
 */
public class GsonTransformer implements ResponseTransformer {
    private final Gson gson;
    
    public GsonTransformer() {
        gson = (new GsonBuilder()).create();
    }
    
    @Override
    public String render(Object o) throws Exception {
        return gson.toJson(o);
    }
}
