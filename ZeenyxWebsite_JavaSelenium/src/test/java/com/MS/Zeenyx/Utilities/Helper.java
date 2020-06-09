package com.MS.Zeenyx.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

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

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	// Screen shots , alerts , frames , windows , sync issues , javascript executor
	
	
		//*************************Capture Snapshot Start**********************************************************
		public static String CaptureScrrenshot(WebDriver driver)
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String ScreenshotPath=System.getProperty("user.dir")+"/Screenshots/ZeenyxPage_"+ GetCurrentDateTime() + ".png";
			
			try {
				
				FileHandler.copy(src,new File(ScreenshotPath));
				
				System.out.println("Screenshot captured");
				
			} catch (IOException e) {
				
				System.out.println("Unable to capture screenshot"+e.getMessage());
				
			}
			return ScreenshotPath;
		}
		//To get current date and time to the snapshot
		public static String GetCurrentDateTime() 
		{
			DateFormat CustomFormat=new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
			
			Date CurrentDate=new Date();
			
			return CustomFormat.format(CurrentDate);
		}
		//*************************Capture Snapshot End**********************************************************

		
		public static void SendMailandAttachReport()
		{
			System.out.println("=============================Email Started=========================================");
			
			
			//authentication info
			final String username = "regression@matryxsoft.com";
			final String password = "Matryx@2020";
			String fromEmail = "regression@matryxsoft.com";
			String toEmail = "pradeep@matryxsoft.com";
			
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.host", "sg2plcpnl0106.prod.sin2.secureserver.net");
			properties.put("mail.smtp.port", "465");
			
			Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username,password);
				}
			});
			//Start our mail message
			MimeMessage msg = new MimeMessage(session);
			try {
				msg.setFrom(new InternetAddress(fromEmail));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
				msg.setSubject("Selenium Test Report");
				
				Multipart emailContent = new MimeMultipart();
				
				//Text body part
				MimeBodyPart textBodyPart = new MimeBodyPart();
				textBodyPart.setText("Hi, \r\n" + 
						"Greetings of the day!\r\n" + 
						"\r\n" + 
						"PFA of Zeenyx Website testcases in java selenium\r\n" + 			 
						"\r\n" + 
						"Please let me know For any clarifications needed.\r\n" + 
						"\r\n" + 
						"Regards,\r\n" + 
						"Vidyashri D\r\n" + 
						" \r\n" + 
						"MATRYXSOFT TECH LLP \r\n" + 
						"#9/2,Near BEL Circle, Hebbal Ring Road \r\n" + 
						"Bengaluru 560094\r\n" + 
						"Website: www.matryxsoft.com\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"");
				
				//Attachment body part.
				MimeBodyPart pdfAttachment = new MimeBodyPart();
				pdfAttachment.attachFile("./Reports/ZeenyxWebsite.html");
				
				//Attach body parts
				emailContent.addBodyPart(textBodyPart);
				emailContent.addBodyPart(pdfAttachment);
				
				//Attach multipart to message
				msg.setContent(emailContent);
				
				Transport.send(msg);
				System.out.println("Sent message");
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			
			System.out.println("=============================Email Ended=========================================");
		}

}
		

