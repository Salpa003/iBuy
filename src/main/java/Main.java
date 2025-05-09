import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String host = "smtp.gmail.com"; // например, для Gmail
        String port = "587";
        String username = "ibuy.official.com@gmail.com"; // замените на вашу почту
        String password = "xqbm xiqv rfml ukhl"; // убедитесь, что включена 2FA или используйте приложение-пароль

        // Получатель и тема сообщения
        String to = "rusik12346rusik@gmail.com";
        String subject = "Тема письма";
        String body = "Это тестовое сообщение";

        // Настройки свойств
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Создание сессии
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Создание сообщения
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            // Отправка сообщения
            Transport.send(message);
            System.out.println("Письмо успешно отправлено");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
