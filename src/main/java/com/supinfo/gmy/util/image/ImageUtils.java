package com.supinfo.gmy.util.image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


/** 
* @Description: 图片处理工具类
* @author: gaomingyang
* @date: 2020-03-27
*/
public class ImageUtils {

	/**
	* @Description: 转换图片到指定尺寸
	* @param source
	* @param targetW
	* @param targetH
	* @return 
	*/ 
	public static BufferedImage resizeImgBySize(BufferedImage source, int targetW, int targetH) {
		BufferedImage target = source;
		if ((source.getHeight() != targetH) || (source.getWidth() != targetW)) {
			int type = source.getType();
			if (type == 0) {
				ColorModel cm = source.getColorModel();
				WritableRaster raster = cm.createCompatibleWritableRaster(targetW, targetH);
				boolean alphaPremultiplied = cm.isAlphaPremultiplied();
				target = new BufferedImage(cm, raster, alphaPremultiplied, null);
			} else {
				target = new BufferedImage(targetW, targetH, 1);
			}
		}
		Graphics2D g = (Graphics2D) target.getGraphics();
		g.drawImage(source, 0, 0, targetW, targetH, null);
		g.dispose();
		target.flush();
		return target;
	}

	/**
	* @Description: 按比例转换转换最小边到 minEdgeSize
	* @param source
	* @param minEdgeSize
	* @return 
	*/ 
	public static BufferedImage scaleImageToSize(BufferedImage source, int minEdgeSize) {
		if (source == null) {
			return null;
		}
		int width = source.getWidth();
		int height = source.getHeight();
		if (width <= 0 || height <= 0) {
			return null;
		}
		int targetW = minEdgeSize;
		int targetH = minEdgeSize;
		if (width > height) {
			targetW = width * targetH / height;
		} else {
			targetH = height * targetW / width;
		}
		// System.out.println("w:" + width + " h:" + height + " tw:" + targetW + " th:" + targetH);
		return resizeImgBySize(source, targetW, targetH);
	}

	/**
	* @Description: 字节数组转换为BufferedImage
	* @param bytes
	* @return
	* @throws IOException 
	*/ 
	public static BufferedImage bytesToBufferedImage(byte[] bytes) throws IOException {
		// 将b作为输入流
		ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
		// 将in作为输入流，读取图片存入image中，而这里in可以为ByteArrayInputStream()
		BufferedImage buff = ImageIO.read(inputStream);
		buff.flush();
		return buff;
	}

	/**
	* @Description: BufferedImage转换为字节数组
	* @param bufferedImage
	* @return
	* @throws IOException 
	*/ 
	public static byte[] bufferedImageToBytes(BufferedImage bufferedImage) throws IOException {
		byte[] bytes = null;
		if (bufferedImage == null) {
			return null;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "jpg", out);
		bytes = out.toByteArray();
		if (out != null) {
			try {
				out.close();
			} catch (IOException e) {
			}
		}
		return bytes;
	}

	public static void main(String[] args) {
		String url = "http://img5.web.hellodns.org/p1/big/123.jpg";
		// System.out.println(Arrays.toString(url.split("/")));
	}
}
