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
	 private static final String QQhost = "smtp.qq.com"; // 邮箱服务器
	 private static final String to = "15207937177@163.com"; // 接受者的邮箱

	// 发件人 账号和密码
	public static final String MY_EMAIL_ACCOUNT = "15207937177@163.com";
	public static final String MY_EMAIL_PASSWORD = "zhu15207937177";// 密码,是你自己的设置的授权码

	// SMTP服务器(这里用的163 SMTP服务器)
	public static final String MEAIL_163_SMTP_HOST = "smtp.163.com";
	public static final String SMTP_163_PORT = "25";// 端口号,这个是163使用到的;QQ的应该是465或者875

	/**
	 * 
	 * @param sender
	 *            发送者的邮箱地址
	 * @param subject
	 *            发送的主题
	 * @param content
	 *            发送的内容
	 * @return
	 */
	public static boolean sendMailBox(String sender, String content) {
		// 获取系统属性
		Properties properties = System.getProperties();
		// 设置邮件服务器
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
		// 获取默认session对象
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				// 登录邮箱及授权码
				return new PasswordAuthentication("1396262570@qq.com", "kikkjllcbaxajhhg");
			}
		});

		try {
			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);
			// Set From: 头部头字段
			message.setFrom(new InternetAddress(sender));
			// Set To: 头部头字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set Subject: 头部头字段
			message.setSubject("WELIFE有消息来了");
			// 设置消息体
			message.setText(sender + "发来了消息：" + content);
			// 发送消息
			Transport.send(message);
			System.out.println("发送邮箱成功！");
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
			// 设置认证账户信息
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MY_EMAIL_ACCOUNT, MY_EMAIL_PASSWORD);
			}
		});
		session.setDebug(true);
		System.out.println("创建邮件");
		MimeMessage message = new MimeMessage(session);
		// 发件人
		message.setFrom(new InternetAddress(MY_EMAIL_ACCOUNT));
		// 收件人和抄送人
		message.setRecipients(Message.RecipientType.TO, to);

		// 内容(这个内容还不能乱写,有可能会被SMTP拒绝掉;多试几次吧)
		message.setSubject("包裹");
		message.setContent("<h1>李总,您好;你的包裹在前台</h1>", "text/html;charset=UTF-8");
		message.setSentDate(new Date());
		message.saveChanges();
		System.out.println("准备发送");
		Transport.send(message);
	}

	public static void main(String[] args) throws AddressException, MessagingException {
//		SendQQMailBox.send163MailBox();
		SendQQMailBox.sendMailBox("15207937177@163.com", "fdfd");
	}
}
