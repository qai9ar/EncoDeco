package gui;
import logic.MainLogic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame implements ActionListener {
    public MainLogic mainLogic;
    private JTextArea toEncodeStringURL;
    private JTextArea toDecodeStringURL;
    private JTextArea toEncodeStringB64;
    private JTextArea toDecodeStringB64;
    private JButton encodingButtonURL;
    private JButton decodingButtonURL;
    private JButton encodingButtonB64;
    private JButton decodingButtonB64;
    private JScrollPane encodeScrollURL;
    private JScrollPane decodeScrollURL;
    private JScrollPane encodeScrollB64;
    private JScrollPane decodeScrollB64;
    private JTabbedPane mainTabbedPane;
    private JPanel URLEncDecPanel;
    private JPanel B64EncDecPanel;
    public MainGUI()
    {
        super("EncoDeco");
        this.mainLogic = new MainLogic(this);
        setupGUI();
    }
    private void setupGUI()
    {
        this.mainTabbedPane = new JTabbedPane();

        this.toEncodeStringURL = new JTextArea(20, 45);
        this.toDecodeStringURL = new JTextArea(20, 45);
        this.toEncodeStringURL.setName("URL_ENC");
        this.toDecodeStringURL.setName("URL_DEC");
        this.toEncodeStringURL.setLineWrap(true);
        this.toEncodeStringURL.setWrapStyleWord(true);
        this.toDecodeStringURL.setLineWrap(true);
        this.toDecodeStringURL.setWrapStyleWord(true);
        this.encodeScrollURL = new JScrollPane(this.toEncodeStringURL);
        this.decodeScrollURL = new JScrollPane(this.toDecodeStringURL);
        this.encodingButtonURL = new JButton("URL Encode");
        this.decodingButtonURL = new JButton("URL Decode");
        this.URLEncDecPanel = new JPanel();

        this.toEncodeStringB64 = new JTextArea(20, 45);
        this.toDecodeStringB64 = new JTextArea(20, 45);
        this.toEncodeStringB64 = new JTextArea(20, 45);
        this.toEncodeStringB64.setName("B64_ENC");
        this.toDecodeStringB64.setName("B64_DEC");
        this.toEncodeStringB64.setLineWrap(true);
        this.toEncodeStringB64.setWrapStyleWord(true);
        this.toDecodeStringB64.setLineWrap(true);
        this.toDecodeStringB64.setWrapStyleWord(true);
        this.encodeScrollB64 = new JScrollPane(this.toEncodeStringB64);
        this.decodeScrollB64 = new JScrollPane(this.toDecodeStringB64);
        this.encodingButtonB64 = new JButton("B64 Encode");
        this.decodingButtonB64 = new JButton("B64 Decode");
        this.B64EncDecPanel = new JPanel();

        this.styleButton(encodingButtonURL);
        this.styleButton(decodingButtonURL);
        this.styleButton(encodingButtonB64);
        this.styleButton(decodingButtonB64);

        Font textFont = new Font("Segue UI", Font.PLAIN, 18);
        this.toEncodeStringURL.setFont(textFont);
        this.toDecodeStringURL.setFont(textFont);
        this.toEncodeStringB64.setFont(textFont);
        this.toDecodeStringB64.setFont(textFont);

        float[] hsbGrey = new float[3];
        Color.RGBtoHSB(255,255,255, hsbGrey);
        this.URLEncDecPanel.setBackground(Color.getHSBColor(hsbGrey[0],hsbGrey[1],hsbGrey[2]));
        this.B64EncDecPanel.setBackground(Color.getHSBColor(hsbGrey[0],hsbGrey[1],hsbGrey[2]));
        this.getContentPane().setBackground(Color.getHSBColor(hsbGrey[0],hsbGrey[1],hsbGrey[2]));

        this.mainTabbedPane.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.mainTabbedPane.setFocusable(false);
        this.mainTabbedPane.setFont(new Font("Sans Serif", Font.PLAIN, 12));

        this.setupLayouts();
        this.mainTabbedPane.add(this.URLEncDecPanel, "URL Encoder & Decoder");
        this.mainTabbedPane.add(this.B64EncDecPanel, "Base64 Encoder & Decoder");

        this.add(this.mainTabbedPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(this);
        this.setVisible(true);

        this.encodingButtonURL.addActionListener(this);
        this.decodingButtonURL.addActionListener(this);
        this.encodingButtonB64.addActionListener(this);
        this.decodingButtonB64.addActionListener(this);
    }
    private void setupLayouts()
    {
        Container URLEncDecContainer = this.URLEncDecPanel;
        GroupLayout URLGL = new GroupLayout(URLEncDecContainer);
        URLEncDecContainer.setLayout(URLGL);
        URLGL.setAutoCreateContainerGaps(true);
        URLGL.setAutoCreateGaps(true);
// =========================================================
        URLGL.setHorizontalGroup(
                URLGL.createSequentialGroup()
                        .addGroup(
                                URLGL.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(this.encodeScrollURL)
                                        .addComponent(this.encodingButtonURL)
                        )
                        .addGroup(
                                URLGL.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(this.decodeScrollURL)
                                        .addComponent(this.decodingButtonURL)
                        )
        );
        URLGL.setVerticalGroup(
                URLGL.createSequentialGroup()
                        .addGroup(
                                URLGL.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(this.encodeScrollURL)
                                        .addComponent(this.decodeScrollURL)
                        )
                        .addGroup(
                                URLGL.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(encodingButtonURL)
                                        .addComponent(decodingButtonURL)
                        )
        );
// =========================================================
        Container B64Container = this.B64EncDecPanel;
        GroupLayout B64GL = new GroupLayout(B64Container);
        B64Container.setLayout(B64GL);
        B64GL.setAutoCreateGaps(true);
        B64GL.setAutoCreateContainerGaps(true);
// =========================================================
        B64GL.setHorizontalGroup(
                B64GL.createSequentialGroup()
                        .addGroup(
                                B64GL.createParallelGroup()
                                        .addComponent(this.encodeScrollB64).addComponent(this.encodingButtonB64)
                        )
                        .addGroup(
                                B64GL.createParallelGroup()
                                        .addComponent(this.decodeScrollB64).addComponent(this.decodingButtonB64)
                        )

        );
        B64GL.setVerticalGroup(
                B64GL.createSequentialGroup()
                        .addGroup(
                                B64GL.createParallelGroup()
                                        .addComponent(this.encodeScrollB64).addComponent(this.decodeScrollB64)
                        )
                        .addGroup(
                                B64GL.createParallelGroup()
                                        .addComponent(this.encodingButtonB64).addComponent(this.decodingButtonB64)
                        )
        );
// =========================================================
    }

    private void styleButton(JButton button)
    {
        button.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        button.setFocusable(false);
        button.setContentAreaFilled(true);
    }

    public void setEncodedURL(String str)
    {
        this.toDecodeStringURL.setText(str);
    }
    public void setDecodedURL(String str)
    {
        this.toEncodeStringURL.setText(str);
    }
    public void setEncodedB64(String str)
    {
        this.toDecodeStringB64.setText(str);
    }
    public void setDecodedB64(String str)
    {
        this.toEncodeStringB64.setText(str);
    }
    public JTextArea getToEncodeURL()
    {
        return this.toEncodeStringURL;
    }
    public JTextArea getToDecodeURL()
    {
        return this.toDecodeStringURL;
    }
    public JTextArea getToEncodeB64()
    {
        return this.toEncodeStringB64;
    }
    public JTextArea getToDecodeB64()
    {
        return this.toDecodeStringB64;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.encodingButtonURL)
        {
            mainLogic.encode(this.getToEncodeURL());
        }
        else if (e.getSource() == this.decodingButtonURL)
        {
            mainLogic.decode(this.getToDecodeURL());
        }
        else if (e.getSource() == this.encodingButtonB64)
        {
            mainLogic.encode(this.getToEncodeB64());
        }
        else if (e.getSource() == this.decodingButtonB64)
        {
            mainLogic.decode(this.getToDecodeB64());
        }
    }
}
