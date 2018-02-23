/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */
package book.store.portal.webservice.client;

import book.store.portal.tx.BookStoreConfigUtil;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * <p>
 *
 * </p>
 *
 */
public abstract class BaseClient {

    private final Client client;

    public BaseClient() {
        client = ClientBuilder.newClient();
    }

    protected Client getClient() {
        return client;
    }

    protected WebTarget createTarget(final String path) {
        return client.target(BookStoreConfigUtil.getWebServiceBaseUrl()).path(path);
    }

    public void close() {
        client.close();
    }
}
