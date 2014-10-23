package com.tenghu.ssh.core.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * 安全的秘密工具类
 * 
 * @author arvin
 * 
 */
public class SecurityPwdUtil {

	/**
	 * 验证密码
	 * 
	 * @param attemptedPassword
	 *            尝试密码
	 * @param password
	 *            密码
	 * @param salt
	 *            盐
	 * @return
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static boolean authenticate(String attemptedPassword,
			String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String pwd = getEncryptedPassword(attemptedPassword, salt);
		return password.trim().equals(pwd.trim());
	}

	/**
	 * 获取密码加密
	 * 
	 * @param password
	 * @param salt
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static String getEncryptedPassword(String password, String salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		String algorithm = "PBKDF2WithHmacSHA1";
		int derivedKeyLength = 160;
		int iterations = 20000;
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(),
				iterations, derivedKeyLength);
		byte[] pwds = null;
		SecretKeyFactory sdf = SecretKeyFactory.getInstance(algorithm);
		pwds = sdf.generateSecret(spec).getEncoded();
		return pwds == null ? "" : StringUtil.byteToStr(pwds);
	}

	/**
	 * 生产密码盐
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public static String generateSalt() throws NoSuchAlgorithmException {
		byte[] salt = new byte[8];
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		random.nextBytes(salt);
		return StringUtil.byteToStr(salt);
	}
}
