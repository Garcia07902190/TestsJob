package com.garcia.testshop.execeptions;

import java.time.LocalDateTime;

/**
 * The type Error detail.
 */
public class ErrorDetail {
    private LocalDateTime timeStamp;
    private String message;
    private String path;
    private String errorCode;

    /**
     * Instantiates a new Error detail.
     */
    public ErrorDetail() {
    }

    /**
     * Instantiates a new Error detail.
     *
     * @param timeStamp the time stamp
     * @param message   the message
     * @param path      the path
     * @param errorCode the error code
     */
    public ErrorDetail(LocalDateTime timeStamp, String message, String path, String errorCode) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.path = path;
        this.errorCode = errorCode;
    }

    /**
     * Gets time stamp.
     *
     * @return the time stamp
     */
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets time stamp.
     *
     * @param timeStamp the time stamp
     */
    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Gets error code.
     *
     * @return the error code
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets error code.
     *
     * @param errorCode the error code
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Gets path.
     *
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets path.
     *
     * @param path the path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
