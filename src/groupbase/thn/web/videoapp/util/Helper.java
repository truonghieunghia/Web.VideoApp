package groupbase.thn.web.videoapp.util;

import java.nio.charset.Charset;

import org.apache.geronimo.mail.util.Base64;

public class Helper {
	public static String base64Encode(String token) {
        byte[] encodedBytes = Base64.encode(token.getBytes());
        return new String(encodedBytes, Charset.forName("UTF-8"));
    }


    public static String base64Decode(String token) {
        byte[] decodedBytes = Base64.decode(token.getBytes());
        return new String(decodedBytes, Charset.forName("UTF-8"));
    }
}
