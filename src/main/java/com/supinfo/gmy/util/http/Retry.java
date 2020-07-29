package com.supinfo.gmy.util.http;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.dao.DuplicateKeyException;

import com.alibaba.fastjson.JSONObject;
import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicates;

public class Retry {

	@Resource
	private XxRpcService xxRpcService;

	/**
	* @Description: retry-high-leve
	* try 3 times
	* @param orderId
	* @param token
	* @return 
	*/
	private JSONObject retryV1(String orderId, String token) {
		JSONObject xxOrder = new JSONObject();
		Callable<JSONObject> callable = new Callable<JSONObject>() {
			@Override
			public JSONObject call() throws Exception {
				JSONObject xxOrder = xxRpcService.getXxxOrder(orderId, token);
				return xxOrder;
			}
		};

		Retryer<JSONObject> retryer = RetryerBuilder.<JSONObject> newBuilder()
				.retryIfResult(Predicates.isNull())
				.retryIfExceptionOfType(Exception.class)
				.retryIfRuntimeException()
				.withWaitStrategy(WaitStrategies.fixedWait(200L, TimeUnit.MILLISECONDS))
				.withStopStrategy(StopStrategies.stopAfterAttempt(3))
				.build();
		try {
			xxOrder = retryer.call(callable);
		} catch (RetryException | ExecutionException e) {

		}
		return xxOrder;
	}

	/**
	* @Description:  retry-low-leve  
	* try 3 times
	*/
	public void retryV2() {
		for (int i = 0; i < 3; i++) {
			try {
				NewHttpUtil.doPost(null, null);
				break;
			} catch (DuplicateKeyException dbException) {

			} catch (Exception e) {

			}
			threadSleep();
		}
	}

	private void threadSleep() {
		try {
			Thread.currentThread();
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
	}

}
