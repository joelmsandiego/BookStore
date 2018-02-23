/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */

package book.store.portal.tx;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <p>
 * </p>
 * 
 */
public abstract class BookStoreConfigUtil {
    private static final String webServiceBaseUrl;
    
    static {
        InputStream ins = BookStoreConfigUtil.class.getClassLoader().getResourceAsStream("bookstore.properties");
        Properties props = new Properties();
        try {
            props.load(ins);
            
            webServiceBaseUrl = props.getProperty("bookstore.ws.base.url", "");
        } catch(IOException ioe) {
            throw new ExceptionInInitializerError(ioe);
        }
    }

    
    public static String getWebServiceBaseUrl() {
        return webServiceBaseUrl;
    }
}
