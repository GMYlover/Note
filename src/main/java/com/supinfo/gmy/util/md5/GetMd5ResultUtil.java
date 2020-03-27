package com.supinfo.gmy.util.md5;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.codec.digest.DigestUtils;

/** 
* @Description: 获取Md5加密结果
* @author: gaomingyang
* @date: 2020-02-15
*/
public class GetMd5ResultUtil {

	private static final String JOINAND = "&";

	private static final String JOINEQUAL = "=";

	/**
	* @Description: 
	* @param paramMap 把加密的key和value都放入map里面
	* 例:Map<String, String> paramMap = new HashMap<String, String>();
	*   paramMap.put(WaterInsuranceConstant.OPENID, request.getOpenId());
	*   paramMap.put(WaterInsuranceConstant.OPENTIME, timeNow);
	* @param factorKey 自定义的加密的key  
	* 例:private static final String factorKey = "randomFactorKey";
	* @param randomFactor 自定义的随机因子
	* 例:private static final String md5RandomFactor=123456
	* @return 
	*/
	public static String getMd5Result(Map<String, String> paramMap, String factorKey, String randomFactor) {
		Map<String, String> treeMap = new TreeMap<String, String>(paramMap);

		// 进行md5
		StringBuffer buffer = new StringBuffer();
		// 拼接
		Iterator<Map.Entry<String, String>> iter = treeMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			buffer.append(entry.getKey()).append(JOINEQUAL).append(entry.getValue()).append(JOINAND);
		}
		buffer.append(factorKey).append(JOINEQUAL).append(randomFactor);
		return DigestUtils.md5Hex(new String(buffer)).toUpperCase();
	}
}
