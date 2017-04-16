package services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import models.MobileNotification;


public class SMTP {
	
	
	public static void sendMail(MobileNotification mn)
    {
		
		System.out.println(mn.getID());
		
		final String username = "kaufland.sensoren@gmail.com";
		final String password = "Kaufland2016";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			
			//Adresse an die es standartmäßig gesendet werden sollte ist kaufland.leitstand@gmail.com
			//Passwort ist Kaufland2016
			
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kaufland.sensoren@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("kaufland.leitstand@gmail.com"));
			
			
			
			Integer process_id = 131;
			
			String store = "2300";
			String departure = "ObstGemuese";
			String sensor = "HR_2300_ObstGemuese_1";
			
			
			
			//Hier könntest du hinschreiben, dass im Markt X in der Abteilung Y der Sensor Z kritische Werte gemeldet hat!
			String subject = "Im Markt " + store + " in der Abteilung" + departure + " hat der Sensor "+ sensor + " kritische Werte gemeldet!";
			
			message.setSubject(subject);
			
			
			//Damit Tasks vom Leitstand abgeschlossen werden können oder ein Schlummermodus gesetzt werden kann, muss 
			//zwingend eine URL der Mail beigefügt werden mit der Referenz zum spezifischen Task
			//Die URL sollte wie folgt aufgebaut werden, wobei die Rauten (#) dynamisch durch Werte ersetzt werden sollten
			//http://localhost:8080/Leitstand/?process_id=###&store=###&departure=###&sensor=###
			// process_id muss zwingend die aktuell gültige ID aus der Tabelle MobileNotification sein, für den die Nachricht erstellt wurde
			//store, departure, sensor haben reinen Anzeigecharackter und sollten sich wie folgt zusammensetzen:
			//store sollte Tabelle Markt die Marktnummer sein
			//departure sollte Tabelle Abteilungstyp die Bezeichnung sein
			//sensor sollte Tabelle Sensoren die Logische_ID sein
				
			
			//Der Link muss dann entsprechend dynamisch zusammengebaut werden
			
			String text = "Um den Fehler zu beheben oder den Schlummermodus zu aktivieren klicken Sie bitte auf den nachfolgenden Link \n \n "
					+ "http://localhost:8080/Leitstand/?process_id="+process_id+"&store="+store+"&departure="+departure+"&sensor="+sensor+" \n"
					+ "um weitere Dinge bearbeiten zu können";
			
			message.setText(text);
			
			
			
			Transport.send(message);

			System.out.println("Mail erfolgreich gesendet");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		
    }
	
}
