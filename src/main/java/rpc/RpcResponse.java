package rpc;

import java.io.Serializable;

public class RpcResponse implements Serializable {
	
	private static final long serialVersionUID = -9202246818200270873L;
	
	boolean isException;
    Object result ;
    Exception exception;
    public boolean isException() {
        return isException;
    }

    public void setException(boolean exception) {
        isException = exception;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
