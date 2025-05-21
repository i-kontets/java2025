package Mail;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.nio.file.StandardCopyOption;
import java.util.Properties;

import javax.swing.plaf.basic.BasicBorders.SplitPaneBorder;

import javax.swing.*;
import java.awt.*;

public class Mail extends JFrame{
    private JTextField tfHost, tfPort, tfUser, tfTo, tfSubject, tfFrom, tfName;
    private JPasswordField pfPass;
    private JTextArea taBody;
    private JButton btnSend;

    //コンストラクタを作成
    public Mail() {
        super("メール送信専用アプリ");
        final String username = "info@burijake.namaste.jp";
        final String password = "AqQnk-1KZpYQJ0v_";

        final String toEmail = "2410019@i-seifu.jp";
        final String fromEmail = "2410019@i-seifu.jp";
        final String fromName = "paiza";
        final String subject = "きさまの件について";
        final String body = """
                            貴様のアカウントを破壊したZOI☆
                            あほしね
                            以上よろしくお願いします。
                            """;


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);

        //レイアウト
        JPanel panel = new JPanel(new BorderLayout(10,10));
        JPanel top = new JPanel(new GridLayout(8,2,5,5));

        top.add(new JLabel("SMTPホスト："));
        tfHost = new JTextField("smtp.lolipop.jp");
        top.add(tfHost);

        top.add(new JLabel("ポート："));
        tfPort = new JTextField("465");
        top.add(tfPort);

        top.add(new JLabel("ユーザー名:"));
        tfUser = new JTextField(username);
        top.add(tfUser);

        top.add(new JLabel("パスワード:"));
        pfPass = new JPasswordField(password);
        top.add(pfPass);

        top.add(new JLabel("送信元のメールアドレス(偽装可能)"));
        tfFrom = new JTextField(fromEmail);
        top.add(tfFrom);

        top.add(new JLabel("送信元の名前(偽装可能)"));
        tfName = new JTextField(fromName);
        top.add(tfName);

        top.add(new JLabel("宛先(To):"));
        tfTo = new JTextField(toEmail);
        top.add(tfTo);

        top.add(new JLabel("件名:"));
        tfSubject = new JTextField(subject);
        top.add(tfSubject);

        panel.add(top,BorderLayout.NORTH);

        taBody = new JTextArea(body, 10, 40);
        JScrollPane scroll = new JScrollPane(taBody);
        panel.add(scroll, BorderLayout.CENTER);

        btnSend = new JButton("送信する");
        btnSend.addActionListener(e -> sendMail());
        panel.add(btnSend, BorderLayout.SOUTH);

        add(panel);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            () -> new Mail().setVisible(true)
        );
    }
    public void sendMail() {
        
        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.lolipop.jp");
        props.put("mail.smtp.port","465");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.ssl.enable","true");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");


        Session session = Session.getInstance(props,new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(tfUser.getText(), new String(pfPass.getPassword()));
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(tfFrom.getText(),tfName.getText(),"UTF-8"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(tfTo.getText()));
            message.setSubject(tfSubject.getText());
            message.setText(taBody.getText());
            for(int i=0;i<20;i++){
                Transport.send(message);
            }
            System.out.println("メール成功");
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    
}
