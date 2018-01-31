package com.cherrish.cloud.support;

/**
 * @author oxchains
 * @time 2018-01-31 14:03
 * @name HttpCode
 * @desc:
 */
public enum  HttpCode {
    /** 200请求成功 */
    HTTP_CODE_200(200),
    /** 207频繁操作 */
    HTTP_CODE_207(207),
    /** 303登录失败 */
    HTTP_CODE_303(303),
    /** 400请求参数出错 */
    HTTP_CODE_400(400),
    /** 401没有登录 */
    HTTP_CODE_401(401),
    /** 403没有权限 */
    HTTP_CODE_403(403),
    /** 404找不到页面 */
    HTTP_CODE_404(404),
    /** 408请求超时 */
    HTTP_CODE_408(408),
    /** 409发生冲突 */
    HTTP_CODE_409(409),
    /** 410已被删除 */
    HTTP_CODE_410(410),
    /** 423已被锁定 */
    HTTP_CODE_423(423),
    /** 500服务器出错 */
    HTTP_CODE_500(500);

    private final Integer value;

    private HttpCode(Integer value) {
        this.value = value;
    }

    /**
     * Return the integer value of this status code.
     */
    public Integer value() {
        return this.value;
    }

    public String msg() {
        //return Resources.getMessage("HTTPCODE_" + this.value);
        return null;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
