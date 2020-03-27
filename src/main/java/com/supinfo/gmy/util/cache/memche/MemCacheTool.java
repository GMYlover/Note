package com.supinfo.gmy.util.cache.memche;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/** 
* @Description: Memcache工具
* https://www.iteye.com/blog/uule-2142890
* @author: gaomingyang
* @date: 2020-03-27
*/
public class MemCacheTool {
	private static Log logger = LogFactory.getLog(MemCacheTool.class);

	// public static MemcachedClient mc;

	/**
	* @Description: 初始化cache 
	* @param connStr 
	*/
	public static void init(String connStr) {
		try {
			// mc = MemcachedClient.getInstrance(connStr);
		} catch (Exception e) {
			logger.error("initMemcacheError:" + connStr, e);
		}
	}

	/**
	* @Description: 通过memcache的特性来实现分布式锁 //当xx秒之内已经存在相同的数据，则返回false
	* @param key
	* @param value
	* @param expir
	* @return 
	*/
	public static boolean lockSyn(String key, String value, int expir) {
		boolean result = false;
		try {
			// result = MemCacheTool.mc.syncAdd(key, value, expir, 500);
			logger.info("lockSynResult:" + key + "," + value + "," + result);
		} catch (Exception e) {
			logger.error("lockSynError:key=" + key + ",value=" + value + ",expir=" + expir, e);
		}
		return result;
	}
}
