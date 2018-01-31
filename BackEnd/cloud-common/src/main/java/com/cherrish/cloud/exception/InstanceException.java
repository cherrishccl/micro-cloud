package com.cherrish.cloud.exception;

import com.cherrish.cloud.support.HttpCode;

/**
 * @author ccl
 * @time 2018-01-31 14:18
 * @name InstanceException
 * @desc:
 */
public class InstanceException extends BaseException{
    public InstanceException() {
        super();
    }

    public InstanceException(Throwable t) {
        super(t);
    }

    @Override
    protected HttpCode getCode() {
        return HttpCode.HTTP_CODE_500;
    }
}
