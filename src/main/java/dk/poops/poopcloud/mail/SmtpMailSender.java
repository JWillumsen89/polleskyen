package dk.poops.poopcloud.mail;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


public class SmtpMailSender implements MailSender {

  private JavaMailSender javaMailSender;

  public SmtpMailSender(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  @Override
  public void send(String to, String subject, String body) throws MessagingException {
    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper;

    try {


      helper = new MimeMessageHelper(message, true);

      helper.setSubject(subject);
      helper.setTo(to);
      helper.setText(body, true);

      javaMailSender.send(message);
    } catch(MessagingException e) {
      System.out.println(e);
    }
  }
}
