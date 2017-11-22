package edu.aiub.cs.geonames.utility;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by bjit on 10/17/17.
 */
public class Utils {

    public static String getUserToken(String name, String email, String phone) {
        System.currentTimeMillis();
        return getSaltedToken(name.concat(phone).concat(email).concat(String.valueOf(System.currentTimeMillis())));
    }

    public static String getAppToken(String appName, String email) {
        System.currentTimeMillis();
        return getSaltedToken(appName.concat(email).concat(String.valueOf(System.currentTimeMillis())));
    }

    public static String getSaltedToken(String text) {
        text = text.concat(Constants.TOKEN_SALT);
        String token = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA1");
            token = new DigestUtils(digest).digestAsHex(text);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return token;
    }
}
