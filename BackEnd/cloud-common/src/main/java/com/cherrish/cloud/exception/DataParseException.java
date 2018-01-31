package com.cherrish.cloud.exception;

import com.cherrish.cloud.support.HttpCode;

/**
 * @author ccl
 * @time 2018-01-31 14:01
 * @name DataParseException
 * @desc:
 */
public class DataParseException extends BaseException{
    public DataParseException() {
    }

    public DataParseException(Throwable ex) {
        super(ex);
    }

    public DataParseException(String message) {
        super(message);
    }

    public DataParseException(String message, Throwable ex) {
        super(message, ex);
    }

    @Override
    protected HttpCode getCode() {
        return HttpCode.HTTP_CODE_500;
    }
}
