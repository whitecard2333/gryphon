package com.oraclecube.whitecard.core.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.*;

/**
 * SimpleSecurityUtils implements:
 * <p>
 * Created by zhouhu on 9/5/2017.
 */
public class SimpleSecurityUtils {
    private static final Logger logger = LoggerFactory.getLogger(SimpleSecurityUtils.class);
    private static Random random = new SecureRandom();
    private static byte[] randomByte = new byte[32];

    public static String sha256Hex(String password, String salt) {
        return DigestUtils.sha256Hex((password + salt).getBytes());
    }

    public static String generateToken(String username, String password) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis()).append(password).append(username);
        UUID uuid = UUID.nameUUIDFromBytes(sb.toString().getBytes());
        return uuid2String(uuid);
    }

    public static String generateSalt() {
        random.nextBytes(randomByte);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < randomByte.length; i++) {
            String hex = Integer.toHexString(0xff & randomByte[i]);
            sb.append(hex);
        }
        return sb.toString();
    }

    private static String uuid2String(UUID uuid) {
        StringBuilder sb = new StringBuilder();
        String str = uuid.toString();
        return sb.append(str.substring(0, 8))
                .append(str.substring(9, 13))
                .append(str.substring(14, 18))
                .append(str.substring(19, 23))
                .append(str.substring(24, 32))
                .toString();
    }

    private SimpleSecurityUtils() {
        throw new IllegalAccessError("SimpleSecurityUtils is a util class");
    }
}
