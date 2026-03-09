package utils;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.File;
import java.util.Properties;

public class EmailUtil {

    public static void sendEmailReport(int total, int passed, int failed, int skipped) {

        final String senderEmail = "test.automation.mansur@gmail.com";
        final String password = "TA@113377";

        String[] recipients = {
                "mansurworkplace@gmail.com",
                "mmjuwel@gmail.com"
        };

        String allureLink = "http://your-server/allure-report/index.html";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));

            InternetAddress[] addressList = new InternetAddress[recipients.length];
            for (int i = 0; i < recipients.length; i++) {
                addressList[i] = new InternetAddress(recipients[i]);
            }

            message.setRecipients(Message.RecipientType.TO, addressList);

            message.setSubject("Automation Test Execution Report");

            String htmlBody =
                    "<h2>Automation Execution Summary</h2>" +
                    "<table border='1' cellpadding='5'>" +
                    "<tr><th>Total</th><th>Passed</th><th>Failed</th><th>Skipped</th></tr>" +
                    "<tr>" +
                    "<td>" + total + "</td>" +
                    "<td style='color:green'>" + passed + "</td>" +
                    "<td style='color:red'>" + failed + "</td>" +
                    "<td style='color:orange'>" + skipped + "</td>" +
                    "</tr>" +
                    "</table>" +
                    "<br>" +
                    "<b>Allure Report:</b> " +
                    "<a href='" + allureLink + "'>Open Allure Report</a>" +
                    "<br><br>" +
                    "TestNG HTML report attached.";

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(htmlBody, "text/html");

            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File("target/surefire-reports/emailable-report.html"));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Report email sent successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}