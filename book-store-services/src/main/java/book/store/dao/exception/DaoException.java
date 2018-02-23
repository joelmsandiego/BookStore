/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.store.dao.exception;

public class DaoException extends Exception {
    private static final long serialVersionUID = 3794165852606546425L;
    
    private String errorCode;
    private String messageKey;

    public DaoException(String errorCode, String messageKey) {
        this.errorCode = errorCode;
        this.messageKey = messageKey;
    }

    public DaoException(String errorCode, String messageKey, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.messageKey = messageKey;
    }

    public DaoException(String errorCode, String messageKey, String message) {
        super(message);
        this.errorCode = errorCode;
        this.messageKey = messageKey;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }
}
