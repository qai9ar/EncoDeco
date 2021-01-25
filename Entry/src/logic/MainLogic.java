package logic;
import gui.MainGUI;
import javax.swing.*;

public class MainLogic {
    public MainGUI mainGUI;

    public MainLogic(MainGUI main)
    {
        this.mainGUI = main;
    }

    public void encode(JTextArea toEncode)
    {
        String encodedString;
        switch (toEncode.getName())
        {
            case "URL_ENC":
                encodedString = new URLEncoding().encode(toEncode);
                this.mainGUI.setEncodedURL(encodedString);
                break;
            case "B64_ENC":
                encodedString = new Base64Encoding().encode(toEncode);
                this.mainGUI.setEncodedB64(encodedString);
                break;
        }
        return;
    }
    public void decode(JTextArea toDecode)
    {
        String decodedString;
        switch (toDecode.getName())
        {
            case "URL_DEC":
                decodedString = new URLEncoding().decode(toDecode);
                this.mainGUI.setDecodedURL(decodedString);
                break;
            case "B64_DEC":
                decodedString = new Base64Encoding().decode(toDecode);
                this.mainGUI.setDecodedB64(decodedString);
                break;
        }
        return;
    }
}
