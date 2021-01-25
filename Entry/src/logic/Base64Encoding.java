package logic;
import javax.swing.*;
import java.util.Base64;

public class Base64Encoding implements MultiEncoderDecoder {
    private static String CHARSET = "UTF-8";

    @Override
    public String encode(JTextArea toEncodeObj) {
        String toEncode = toEncodeObj.getText();
        String encoded = new String();
        try
        {
            encoded = Base64.getEncoder().encodeToString(toEncode.getBytes(CHARSET));
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return encoded;
    }

    @Override
    public String decode(JTextArea toDecodeObj) {
        String toDecode = toDecodeObj.getText();
        String decoded = new String();
        try
        {
            decoded = new String(Base64.getDecoder().decode(toDecode));
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return decoded;
    }
}
