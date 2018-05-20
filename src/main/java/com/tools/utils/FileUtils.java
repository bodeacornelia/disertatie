package com.tools.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.imageio.ImageIO;

public class FileUtils {

	public static String calculateFileChecksum(String filePath) throws NoSuchAlgorithmException, Exception {

		File input = new File(filePath);

		BufferedImage buffImg = ImageIO.read(input);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ImageIO.write(buffImg, "jpg", outputStream);
		byte[] data = outputStream.toByteArray();

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(data);
		byte[] hash = md.digest();
		return returnHex(hash);
	}

	static String returnHex(byte[] inBytes) throws Exception {
		String hexString = "";
		for (int i = 0; i < inBytes.length; i++) {
			hexString += Integer.toString((inBytes[i] & 0xff) + 0x100, 16).substring(1);
		}
		return hexString;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException, Exception {
		System.out.println("Expected: " + calculateFileChecksum(
				"/home/corneliabodea/disertatie/disertatiePractic/docker/upload/photo.jpg"));
		System.out.println("Actual: " + calculateFileChecksum(
				"/home/corneliabodea/disertatie/disertatiePractic/docker/Downloads/nelly-1094789.jpg"));
	}

	// public static byte[] calculateFileChecksum(String filePath) {
	// MessageDigest md;
	// try {
	// md = MessageDigest.getInstance("MD5");
	// InputStream is = Files.newInputStream(Paths.get(filePath));
	// DigestInputStream dis = new DigestInputStream(is, md);
	// byte[] b = md.digest();
	//
	// return md.digest();
	// } catch (NoSuchAlgorithmException e) {
	// e.printStackTrace();
	// return null;
	// } catch (IOException e) {
	// e.printStackTrace();
	// return null;
	// }

	// FileInputStream fis;
	// try {
	// fis = new FileInputStream(new File(filePath));
	// String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
	// fis.close();
	// return md5;
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// return null;
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// return null;
	// }
	// }
}
