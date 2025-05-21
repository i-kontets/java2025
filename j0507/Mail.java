package j0507;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.nio.file.StandardCopyOption;
import java.util.Properties;

import javax.swing.plaf.basic.BasicBorders.SplitPaneBorder;

public class Mail {
    public static void main(String[] args) {

        final String username = "info@yuki6800.main.jp";
        final String password = "3w_A3-H_--nP_H1-";

        final String toEmail = "2400045@i-seifu.jp";
        final String fromEmail = "2410028@i-seifu.jp";
        final String fromName = "林";
        final String title = "冷蔵庫の件";
        final String body = """
                            お昼休み職員室に来てください

                            以上よろしくお願いします。

                            """;

        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.lolipop.jp");
        props.put("mail.smtp.port","465");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.ssl.enable","true");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");


        Session session = Session.getInstance(props,new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail,fromName,"UTF-8"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toEmail));
            message.setSubject(title);
            message.setText(body);

            Transport.send(message);
            System.out.println("メール成功");
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }


        
    }
    
}
