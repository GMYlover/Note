package com.supinfo.gmy.util.RegexUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;


/** 
* @Description: 正则工具类
* @author: gaomingyang
* @date: 2020-03-27
*/
public class RegexUtil {

	// 所有数字正则
	private static final Pattern ALL_NUMBERS_PATTERN = Pattern.compile("^[0-9]*$");

	// 8位数字正则
	private static final Pattern EIGHT_NUMBERS_PATTERN = Pattern.compile("\\d{8,}");

	// 6位字符 正则
	private static final Pattern SIX_CHARS_PATTERN = Pattern.compile("[0-9A-Za-z]{6,}");

	// 6位数字正则
	private static final Pattern SIX_NUMBERS_PATTERN = Pattern.compile("\\d{6,}");

	// QQ 微信 二维码正则
	private static final Pattern QR_QW_PATTERN =
			Pattern.compile("[q][q][.][c][o][m]|[w][e][c][h][a][t][.][c][o][m]");

	// 手机号正则
	private static final Pattern TELNUM_PATTERN =
			Pattern.compile("^((18)|(13)|(15)|(17)|(400)|(800)).*");

	// 手机/QQ正则
	public static Pattern telQQPattern;

	// 微信正则
	public static Pattern weChatPattern;

	public static boolean checkContainTelNum(String text) {
		Matcher digitsMatcher = EIGHT_NUMBERS_PATTERN.matcher(text);
		while (digitsMatcher.find()) {
			String num = digitsMatcher.group();
			Matcher telNumMatcher = TELNUM_PATTERN.matcher(num);
			if (telNumMatcher.find()) {
				return true;
			}
		}
		return false;
	}

	public static String checkWeChatWord(String text) {
		Matcher matcher = weChatPattern.matcher(text);
		if (matcher.find()) {
			return matcher.group();
		}
		return null;
	}

	public static boolean checkSixChars(String text) {
		Matcher matcher = SIX_CHARS_PATTERN.matcher(text);
		return matcher.find();
	}

	public static String getTelQQWord(String text) {
		Matcher matcher = telQQPattern.matcher(text);
		if (matcher.find()) {
			return matcher.group();
		}
		return null;
	}

	public static boolean checkSixNumbers(String text) {
		Matcher matcher = SIX_NUMBERS_PATTERN.matcher(text);
		return matcher.find();
	}

	public static String getEightNumbers(String text) {
		Matcher matcher = EIGHT_NUMBERS_PATTERN.matcher(text);
		if (matcher.find()) {
			return matcher.group();
		}
		return null;
	}

	public static boolean checkQQWeChatQr(String text) {
		Matcher matcher = QR_QW_PATTERN.matcher(text);
		return matcher.find();
	}

	public static boolean checkNumeric(String text) {
		if (text == null || text.length() == 0) {
			return false;
		}
		Matcher matcher = ALL_NUMBERS_PATTERN.matcher(text);
		return matcher.matches();
	}

	public static List<String> getAllValue(String input, String regex) {
		if (StringUtils.isEmpty(input) || StringUtils.isEmpty(regex)) {
			return null;
		}

		List<String> result = new ArrayList<String>();
		Matcher matcher = Pattern.compile(regex).matcher(input);
		while (matcher.find()) {
			String str = matcher.group();
			result.add(str);
		}

		return result;
	}

	public static String getValue(String input, String regex, int group) {
		Matcher matcher = Pattern.compile(regex).matcher(input);
		if (matcher.find()) {
			return matcher.group(group);
		}

		return null;
	}

}