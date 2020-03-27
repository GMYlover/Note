package com.supinfo.gmy.util.cache.localcache;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/** 
* @Description: 本地缓存,通过定时任务更新map,再从map里面获取信息
* @author: gaomingyang
* @date: 2020-03-27
*/
public class ConfigCache {

	private static Log logger = LogFactory.getLog(ConfigCache.class);

	/**
	 * 注意:本地缓存的map一定要声明成static
	 */
	private static Map<Integer, Map<String, String>> mapParams =
			new HashMap<Integer, Map<String, String>>();

	private static void init() throws Exception {
		// 初始化类别-单元参数
		mapParams = initCateParams();
		logger.info("Load mapParams finished!");
	}

	public static Map<Integer, Map<String, String>> getMapParams() {
		return mapParams;
	}

	/**
	 * 初始化数据同步任务
	 * @throws Exception 
	 */
	public static void initConfigCache() throws Exception {
		ConfigCache.init();
		// 定时任务 10 分钟
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				// 每小时定时更新缓存
				try {
					ConfigCache.init();
				} catch (Exception e) {
					logger.error("refreshHourCache Task error!", e);
				}
			}
		}, 10 * 60 * 1000, 10 * 60 * 1000);
	}

	public static Map<Integer, Map<String, String>> initCateParams() {

		Map<Integer, Map<String, String>> changingParams =
				new HashMap<Integer, Map<String, String>>();
		// 通过服务获取实时更新的信息并放入changingParams的map里，并返回
		return changingParams;
	}
}