package logic;
import javax.swing.*;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.Charset;

public class URLEncoding implements MultiEncoderDecoder {
    private static String CHARSET = "UTF-8";

    @Override
    public String encode(JTextArea toEncode)
    {
        String encoded = new String();
        try
        {
            encoded = URLEncoder.encode(toEncode.getText(), Charset.forName(CHARSET));
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return encoded;
    }

    @Override
    public String decode(JTextArea toDecode)
    {
        String decoded = new String();
        try
        {
            decoded = URLDecoder.decode(toDecode.getText(), Charset.forName(CHARSET));
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return decoded;
    }
}
