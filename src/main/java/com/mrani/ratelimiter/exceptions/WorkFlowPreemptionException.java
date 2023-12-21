package com.mrani.ratelimiter.exceptions;


import org.springframework.core.NestedRuntimeException;
/**
 * @author manjushaRani
 */

public class WorkFlowPreemptionException extends NestedRuntimeException {
    private final String exceptionMessage;

    public WorkFlowPreemptionException(String msg) {
        super(msg);
        exceptionMessage = msg;
    }

    public WorkFlowPreemptionException(String msg, Throwable cause) {
        super(msg, cause);
        exceptionMessage = msg;
    }

    public String getExceptionMessage() {
        final Throwable mostSpecificCause = this.getMostSpecificCause();
        if (mostSpecificCause instanceof IllegalArgumentException ||
                mostSpecificCause instanceof IllegalStateException) {
            return mostSpecificCause.getMessage();
        } else {
            return this.exceptionMessage;
        }
    }
}
