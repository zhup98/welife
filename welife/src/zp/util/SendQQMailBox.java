package zp.util;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendQQMailBox {
	 private static final String QQhost = "smtp.qq.com"; // ���������
	 private static final String to = "15207937177@163.com"; // �����ߵ�����

	// ������ �˺ź�����
	public static final String MY_EMAIL_ACCOUNT = "15207937177@163.com";
	public static final String MY_EMAIL_PASSWORD = "zhu15207937177";// ����,�����Լ������õ���Ȩ��

	// SMTP������(�����õ�163 SMTP������)
	public static final String MEAIL_163_SMTP_HOST = "smtp.163.com";
	public static final String SMTP_163_PORT = "25";// �˿ں�,�����163ʹ�õ���;QQ��Ӧ����465����875

	/**
	 * 
	 * @param sender
	 *            �����ߵ������ַ
	 * @param subject
	 *            ���͵�����
	 * @param content
	 *            ���͵�����
	 * @return
	 */
	public static boolean sendMailBox(String sender, String content) {
		// ��ȡϵͳ����
		Properties properties = System.getProperties();
		// �����ʼ�������
		 properties.setProperty("mail.smtp.host", QQhost);
		properties.put("mail.smtp.auth", "true");
		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		sf.setTrustAllHosts(true);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.socketFactory", sf);
		// ��ȡĬ��session����
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				// ��¼���估��Ȩ��
				return new PasswordAuthentication("1396262570@qq.com", "kikkjllcbaxajhhg");
			}
		});

		try {
			// ����Ĭ�ϵ� MimeMessage ����
			MimeMessage message = new MimeMessage(session);
			// Set From: ͷ��ͷ�ֶ�
			message.setFrom(new InternetAddress(sender));
			// Set To: ͷ��ͷ�ֶ�
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set Subject: ͷ��ͷ�ֶ�
			message.setSubject("WELIFE����Ϣ����");
			// ������Ϣ��
			message.setText(sender + "��������Ϣ��" + content);
			// ������Ϣ
			Transport.send(message);
			System.out.println("��������ɹ���");
			return true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return false;
	}

	public static void send163MailBox() throws AddressException, MessagingException {
		Properties p = new Properties();
		p.setProperty("mail.smtp.host", MEAIL_163_SMTP_HOST);
		p.setProperty("mail.smtp.port", SMTP_163_PORT);
		p.setProperty("mail.smtp.socketFactory.port", SMTP_163_PORT);
		p.setProperty("mail.smtp.auth", "true");
		p.setProperty("mail.smtp.socketFactory.class", "SSL_FACTORY");

		Session session = Session.getInstance(p, new Authenticator() {
			// ������֤�˻���Ϣ
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MY_EMAIL_ACCOUNT, MY_EMAIL_PASSWORD);
			}
		});
		session.setDebug(true);
		System.out.println("�����ʼ�");
		MimeMessage message = new MimeMessage(session);
		// ������
		message.setFrom(new InternetAddress(MY_EMAIL_ACCOUNT));
		// �ռ��˺ͳ�����
		message.setRecipients(Message.RecipientType.TO, to);

		// ����(������ݻ�������д,�п��ܻᱻSMTP�ܾ���;���Լ��ΰ�)
		message.setSubject("����");
		message.setContent("<h1>����,����;��İ�����ǰ̨</h1>", "text/html;charset=UTF-8");
		message.setSentDate(new Date());
		message.saveChanges();
		System.out.println("׼������");
		Transport.send(message);
	}

	public static void main(String[] args) throws AddressException, MessagingException {
//		SendQQMailBox.send163MailBox();
		SendQQMailBox.sendMailBox("15207937177@163.com", "fdfd");
	}
}
