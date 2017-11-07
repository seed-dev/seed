package com.github.seedm.entities.enumeration;

/**
 * Http状态码枚举
 * @author Eugene
 */
public enum HttpStatusCodeEnum {

    OK(200), BADREQUEST(400), NOTFOUND(404),
    INTERNALSERVERERROR(500), BADGATEWAY(502), SERVICEUNAVAILABLE(503), GATEWAYTIMEOUT(504), HTTPVERSIONNOTSUPPORTED(505);

    private int statusCode;

    HttpStatusCodeEnum(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
