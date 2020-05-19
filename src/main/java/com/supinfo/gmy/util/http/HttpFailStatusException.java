package com.supinfo.gmy.util.http;

import java.text.MessageFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * HTTP状态不为200的异常
 *
 * @Author fanqiang
 * @Date 2020-03-7
 * @Version 1.0
 */
@Getter
@Setter
@ToString
public class HttpFailStatusException extends Exception {
    private final int httpStatus;
    private final String httpResponse;

    public HttpFailStatusException(String url, int httpStatus, String httpResponse) {
        super(MessageFormat
                .format("Send request to {0} failed. Response status code is {1}, response is {2}", url, httpStatus,
                        httpResponse));
        this.httpResponse = httpResponse;
        this.httpStatus = httpStatus;
    }
}
