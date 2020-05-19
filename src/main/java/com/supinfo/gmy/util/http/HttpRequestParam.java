package com.supinfo.gmy.util.http;

import com.alibaba.fastjson.JSONObject;

import lombok.Getter;
import lombok.Setter;

/**
 * Http请求参数
 *
 * @Author fanqiang
 * @Date 2020-03-15
 * @Version 1.0
 */

@Getter
@Setter
public class HttpRequestParam {
	private String httpHost;
	private String uri;
	private JSONObject headers;
	private String body;
	private int connTimeout;
	private int soTimeout;
	private String proxyHost;
	private int proxyPort;
}
