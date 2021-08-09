package com.proiect_PS.resurse.factory;

import com.itextpdf.text.DocumentException;
import com.proiect_PS.resurse.dto.CartCredentialsDTO;
import com.proiect_PS.resurse.model.Orders;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class EmailSender {
    public void sendEmail(String to, Orders order) throws DocumentException, IOException {

        PdfGenerator pdf=new PdfGenerator();
        pdf.generate(order);

        try {
            String host = "smtp.gmail.com";
            String from = "testconfirmation789@gmail.com";
            String pass = "vkgdcwqsttabhrci";
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", from);
            props.put("mail.smtp.password", pass);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getInstance(props, new GMailAuthenticator("testconfirmation789", pass));
            MimeMessage message = new MimeMessage(session);
            Address fromAddress = new InternetAddress(from);
            Address toAddress = new InternetAddress(to);

            MimeBodyPart messageBodyPart ;

            Multipart multipart = new MimeMultipart();

            messageBodyPart = new MimeBodyPart();

            messageBodyPart.attachFile("C:\\Users\\danci\\Desktop\\Proj\\resurse\\raport.pdf");

            messageBodyPart.setFileName("raport.pdf");
            multipart.addBodyPart(messageBodyPart);

            message.setFrom(fromAddress);
            message.setRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject("Confirmare comanda");
            message.setContent(multipart);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            message.saveChanges();
            Transport.send(message);
            transport.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }



    }
}
