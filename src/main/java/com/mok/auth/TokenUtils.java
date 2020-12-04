package com.mok.auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.security.crypto.codec.Hex;

import com.mok.entity.Account;


public class TokenUtils
{

	public static final String MAGIC_KEY = "MasterOfKindoms";


	public static String createToken(Account account)
	{
		/* Expires in one hour */
		long expires = System.currentTimeMillis() + 1000L * 60 * 60 * 12;
		
		StringBuilder tokenBuilder = new StringBuilder();
		tokenBuilder.append(account.getUserId());
		tokenBuilder.append("=");
		tokenBuilder.append(expires);
		tokenBuilder.append("=");
		tokenBuilder.append(TokenUtils.computeSignature(account, expires));

		return tokenBuilder.toString();
	}


	public static String computeSignature(Account account, long expires)
	{
		StringBuilder signatureBuilder = new StringBuilder();
		signatureBuilder.append(account.getUserId());
		signatureBuilder.append("=");
		signatureBuilder.append(expires);
		signatureBuilder.append("=");
		signatureBuilder.append(account.getUdid());
		signatureBuilder.append("=");
		signatureBuilder.append(TokenUtils.MAGIC_KEY);

		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("No MD5 algorithm available!");
		}

		return new String(Hex.encode(digest.digest(signatureBuilder.toString().getBytes())));
	}


	public static String getUserIdFromToken(String authToken)
	{
		if (null == authToken) {
			return null;
		}

		String[] parts = authToken.split("=");
		return parts[0];
	}


	public static boolean validateToken(String authToken, Account account)
	{
		String[] parts = authToken.split("=");
		long expires = Long.parseLong(parts[1]);
		String signature = parts[2];

		if (expires < System.currentTimeMillis()) {
			return false;
		}

		return signature.equals(TokenUtils.computeSignature(account, expires));
	}
}
