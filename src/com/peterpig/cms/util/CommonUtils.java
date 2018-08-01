package com.peterpig.cms.util;

/**
 * 公共工具包
 * @author JackieL
 *
 */
public class CommonUtils {
	/**  选择排序的类型  */
	public static String orderType;
	
	/**
	 * 静态方法，可以在其他类中直接调用，此方法为选择排序的类型是降序还是升序
	 * @param order 前台传过来的参数
	 * @return 当前台传递过来参数为0返回升序，当前台传递过的参数为1则返回desc降序
	 */
	public static String chooseOrderType(Integer order){
		if(order==0){
			orderType="asc";
		}else{
			orderType="desc";
		}
		
		return orderType;
	}
}
