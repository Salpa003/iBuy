package util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public final class MailManager {
    private static String username;
    private static String password;
    private static Session session;

    static {
        String host = "smtp.gmail.com"; // например, для GmailAdd commentMore actions
        String port = "587";
        username = "ibuy.official.com@gmail.com"; // замените на вашу почту
        password = "xqbm xiqv rfml ukhl"; // убедитесь, что включена 2FA или используйте приложение-пароль

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    public static int sendCode(String mail) {
        String subject = "Код подтверждения";
        int code = generate();
        String body = "Ваш код: " + code;
        try {
            // Создание сообщения
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
            message.setSubject(subject);
            message.setText(body);

            // Отправка сообщения
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return code;
    }

    private static int generate() {
        Random random = new Random();
        int code = 0;
        for (int i = 0; i < 6; i++) {
            code = code * 10 + random.nextInt(1, 10);
        }
        return code;
    }
}
