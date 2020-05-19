package com.supinfo.gmy.util.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
/*import com.bxbank.channel.common.common.utils.StringUtil;
import com.bxbank.channel.common.log.BxLogger;
import com.bxbank.channel.common.log.BxLoggerFactory;*/

/** 
* @Description: http请求工具类
* @author: gaomingyang
* @date: 2020-05-15
*/
public final class NewHttpUtil {

	// private static final BxLogger LOGGER = BxLoggerFactory.getLogger(NewHttpUtil.class);
	private NewHttpUtil() {

	}

	/**
	 * 发送post请求
	 */
	public static String doPost(HttpRequestParam httpRequestParam, JSONObject paramsJson)
			throws HttpFailStatusException, IOException {
		// LOGGER.log("MPB18110", "Send post request to " + httpRequestParam.getHttpHost() + httpRequestParam.getUri());

		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpPost request = new HttpPost(httpRequestParam.getUri());

			if (!Objects.isNull(paramsJson)) {
				List<BasicNameValuePair> pair = new ArrayList<>();
				for (String key : paramsJson.keySet()) {
					pair.add(new BasicNameValuePair(key, paramsJson.getString(key)));
				}
				request.setEntity(new UrlEncodedFormEntity(pair));
			}

			if (httpRequestParam.getBody() != null) {
				StringEntity se = new StringEntity(httpRequestParam.getBody());
				se.setContentType("text/json");
				request.setEntity(se);
			}

			if (null != httpRequestParam.getHeaders() && !httpRequestParam.getHeaders().isEmpty()) {
				for (String key : httpRequestParam.getHeaders().keySet()) {
					request.addHeader(key, httpRequestParam.getHeaders().getString(key));
				}
			}

			request.setConfig(buildBuilder(httpRequestParam).build());
			HttpHost target = HttpHost.create(httpRequestParam.getHttpHost());
			CloseableHttpResponse response = httpClient.execute(target, request);
			try {
				int statusCode = response.getStatusLine().getStatusCode();
				String responseMessage = EntityUtils.toString(response.getEntity());
				if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
					throw new HttpFailStatusException(httpRequestParam.getHttpHost() + httpRequestParam.getUri(),
							statusCode,
							responseMessage);
				}
				// LOGGER.log("MPB18111", "Post response is: " + responseMessage);
				return responseMessage;
			} finally {
				response.close();
			}
		} finally {
			httpClient.close();
		}
	}

	/**
	* @Description: 配置 request 参数
	* @param httpRequestParam
	* @return 
	*/
	private static RequestConfig.Builder buildBuilder(HttpRequestParam httpRequestParam) {
		RequestConfig.Builder builder = RequestConfig.custom();
		if (StringUtils.isNotBlank(httpRequestParam.getProxyHost())) {
			HttpHost proxy = new HttpHost(httpRequestParam.getProxyHost(), httpRequestParam.getProxyPort(), "http");
			builder.setProxy(proxy);
		}

		if (httpRequestParam.getConnTimeout() > 0) {
			builder.setConnectionRequestTimeout(httpRequestParam.getConnTimeout());
		}

		if (httpRequestParam.getSoTimeout() > 0) {
			builder.setSocketTimeout(httpRequestParam.getSoTimeout());
		}
		return builder;

	}

}
