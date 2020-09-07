package com.supinfo.gmy.jdk8;

/** 
* @Description: stream 常见用法
* @author: gaomingyang
* @date: 2020-08-27
*/
public class StreamDemo {

	/**
	* @Description:  map用法收集list对象里面的特定字段到新list里面,不用写成foreach去遍历并add,更优雅
	*/
	private void mapDemo() {
		/*
		 * List<String> partnerIds =
				partnerUserInfoList.stream().map(PartnerUserInfo::getPartnerId).collect(Collectors.toList());*/

	}

	/**
	* @Description:  map过滤和比较用法
	*/ 
	private void filterAndComparatorAndIsPresentDemo() {
		/*       Optional<LimitDetailResponse> limitDetail = limitDetailResponses.stream()
		        .filter(p -> productId.equals(p.getProductCode()))
		        .max(Comparator.comparing(LimitDetailResponse::getModifiedTime));
				if (!limitDetail.isPresent()) {
				    if (throwException) {
				        throw new ErrorCodeException(ErrorCodeEnum.LIMIT_QUERY);
				    } else {
				        return null;
				    }
				}*/
	}
	
	/**
	* @Description:  findFirst用法
	*/ 
	private void findFirstDemo() {
/*		  Optional<ProcProcessNode> processNodeOptional = nodeList.stream().
	                filter(node -> Objects.equals(node.getNodeCode(), nodeCode)).findFirst();
	        if (processNodeOptional.isPresent()) {
	            return processNodeOptional.get();
	        }*/
	}

}
