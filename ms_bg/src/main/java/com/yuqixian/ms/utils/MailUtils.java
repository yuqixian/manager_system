package com.yuqixian.ms.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件处理
 *
 */
public class MailUtils {

	public static void sendMail(String email, String name) {

		try {

			Properties props = new Properties();
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host","smtp.163.com");// smtp服务器地址

			Session session = Session.getInstance(props);

			// 打印调试信息
			// session.setDebug(true);

			Message msg = new MimeMessage(session);
			msg.setSubject("贤哥管理系统");
			msg.setText("尊敬的用户 "+name+" 您好,恭喜您成功注册贤哥管理系统，请及时查看！");
			msg.setFrom(new InternetAddress("yzqwxw@163.com"));// 发件人邮箱(我的163邮箱)
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email)); // 收件人邮箱(我的QQ邮箱)
			msg.saveChanges();
			Transport transport = session.getTransport();
			transport.connect("yzqwxw@163.com","JZQDIGQFAVMDVMXM");// 发件人邮箱,授权码(可以在邮箱设置中获取到授权码的信息)

			transport.sendMessage(msg, msg.getAllRecipients());

			transport.close();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}