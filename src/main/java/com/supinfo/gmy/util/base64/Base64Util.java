package com.supinfo.gmy.util.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/** 
* @Description:  
* 定义:Base64已经成为网络上常见的传输8Bit字节代码的编码方式之一。
* 1 bit名称是位或比特 只能表示0或者1中     标识方式:Bit
* 1 byte=8bit byte是字节的意思是文件的基本单位 标识方式:B
* 一个英文单词一个字节也就是8bit，一个汉字2字节也就是16bit
* 1B=8 Bit
* 1KB＝1024B
* 1MB＝1024KB
* 1GB＝1024MB
* 1TB=1024GB
* 1PB=1024TB
* 1EB=1024PB
* 1ZB=1024EB
* 1YB=1024ZB
* 1BB=1024YB
* 使用原因:
* 在参数传输的过程中经常遇到的一种情况：使用全英文的没问题，但一旦涉及到中文就会出现乱码情况。
* 与此类似，网络上传输的字符并不全是可打印的字符，比如二进制文件、图片等。Base64的出现就是为了解决此问题
* Base64的出现就是为了解决此问题，它是基于64个可打印的字符来表示二进制的数据的一种方法。
* 电子邮件刚问世的时候，只能传输英文，但后来随着用户的增加，中文、日文等文字的用户也有需求，但这些字符并不能被服务器或网关有效处理，
* 因此Base64就登场了。随之，Base64在URL、Cookie、网页传输少量二进制文件中也有相应的使用。
* 例子:
* 在做支付系统时，系统之间的报文交互都需要使用Base64对明文进行转码，然后再进行签名或加密，之后再进行（或再次Base64）传输。
* 编码原理：
* ['A', 'B', 'C', ... 'a', 'b', 'c', ... '0', '1', ... '+', '/']
* 上面就是Base64的索引表，字符选用了"A-Z、a-z、0-9、+、/" 64个可打印字符，这是标准的Base64协议规定。(26+26+10+2=64)
* 在日常使用中我们还会看到“=”或“==”号出现在Base64的编码结果中
* 转换规则:
* 第一步，将待转换的字符串每三个字节分为一组，每个字节占8bit，那么共有24个二进制位。
* 第二步，将上面的24个二进制位每6个一组，共分为4组。
* 第三步，在每组前面添加两个0，每组由6个变为8个二进制位，总共32个二进制位，即四个字节。
* 第四步，根据Base64编码对照表（见下图）获得对应的值。
* Base64字符表中的字符原本用6个bit就可以表示，现在前面添加2个0，变为8个bit，会造成一定的浪费。因此，Base64编码之后的文本，要比原文大约三分之一。
* 为什么使用3个字节一组呢？因为6和8的最小公倍数为24，三个字节正好24个二进制位，每6个bit位一组，恰好能够分为4组。 
* 如果24位数每6个分为一组不足4组时，缺少的组用=标识，比如只能分为2组，则是xx==
* 注意事项：
* 大多数编码都是由字符串转化成二进制的过程，而Base64的编码则是从二进制转换为字符串。与常规恰恰相反，
* Base64编码主要用在传输、存储、表示二进制领域，不能算得上加密，只是无法直接看到明文。也可以通过打乱Base64编码来进行加密。
* 中文有多种编码（比如：utf-8、gb2312、gbk等），不同编码对应Base64编码结果都不一样。
* @author: gaomingyang
* @date: 2020-03-27
*/
public class Base64Util {
	private static final String UTF_8 = "utf-8";

	public static void main(String[] args) {
		String orig = "hello world!";
		String desc;
		String unDecodeStr;
		try {
			desc = Base64.getEncoder().encodeToString(orig.getBytes(UTF_8));
			System.out.println("加密后的字符串为:" + desc);
			unDecodeStr = new String(Base64.getDecoder().decode(desc), UTF_8);
			System.out.println("解密后的字符串为" + unDecodeStr);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
