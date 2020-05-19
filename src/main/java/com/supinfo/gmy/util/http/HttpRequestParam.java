package com.supinfo.gmy.util.http;

import com.alibaba.fastjson.JSONObject;


public class HttpRequestParam {
	private String httpHost;
	private String uri;
	private JSONObject headers;
	private String body;
	private int connTimeout;
	private int soTimeout;
	private String proxyHost;
	private int proxyPort;
	public String getHttpHost() {
		return httpHost;
	}
	public void setHttpHost(String httpHost) {
		this.httpHost = httpHost;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public JSONObject getHeaders() {
		return headers;
	}
	public void setHeaders(JSONObject headers) {
		this.headers = headers;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getConnTimeout() {
		return connTimeout;
	}
	public void setConnTimeout(int connTimeout) {
		this.connTimeout = connTimeout;
	}
	public int getSoTimeout() {
		return soTimeout;
	}
	public void setSoTimeout(int soTimeout) {
		this.soTimeout = soTimeout;
	}
	public String getProxyHost() {
		return proxyHost;
	}
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}
	public int getProxyPort() {
		return proxyPort;
	}
	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}
	
	
}
