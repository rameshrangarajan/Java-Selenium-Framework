package com.saf.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.saf.global.Global;


public class SendAttachment extends Global {
	
 private static final String SERVER = null;
private static final String SMTP = null;
private static final String Subject = null;
private static final String EmailBody = null;
private static final String EmailFile = null;
private static final String Attachment = null;

public static void sendMail() throws Exception{

  String to="";//change accordingly
  final String user="";//change accordingly
  final String password="";//change accordingly
 
  //1) get the session object   
  Properties properties = System.getProperties();
  
  properties.setProperty(SMTP, SERVER);//change accordingly
  //properties.put("mail.smtp.auth", "true");

  Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
   return new PasswordAuthentication(user,password);
   }
  });
   
  //2) compose message   
  try{
    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress(user));
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
    message.setSubject(Subject+new DateTime().ymdhmsTime());  
    
    
    //3) create MimeBodyPart object and set your message content    
    BodyPart messageBodyPart1 = new MimeBodyPart();
    messageBodyPart1.setText(EmailBody);
    
    //4) create new MimeBodyPart object and set DataHandler object to this object    
    MimeBodyPart messageBodyPart2 = new MimeBodyPart();
    
    String filename = EmailFile;//change accordingly
    DataSource source = new FileDataSource(filename);
    messageBodyPart2.setDataHandler(new DataHandler(source));
    messageBodyPart2.setFileName(Attachment+new DateTime().hmsTime());
   
   
    //5) create Multipart object and add MimeBodyPart objects to this object    
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart1);
    multipart.addBodyPart(messageBodyPart2);

    //6) set the multiplart object to the message object
    message.setContent(multipart );
   
    //7) send message
    Transport.send(message);
 
   System.out.println("Message Sent....");
   }catch (MessagingException ex) {ex.printStackTrace();}
 }
}