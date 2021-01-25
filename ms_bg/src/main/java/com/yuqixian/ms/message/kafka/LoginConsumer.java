package com.yuqixian.ms.message.kafka;

import com.alibaba.fastjson.JSON;
import com.yuqixian.ms.domain.message.LoginMessage;
import com.yuqixian.ms.utils.MailUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginConsumer{

    @KafkaListener(topics = {"ms"})
    public void consumer(ConsumerRecord<?, ?> consumerRecord) {
        // 判断是否为null
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        if (kafkaMessage.isPresent()) {
            // 得到Optional实例中的值
            String message = kafkaMessage.get().toString();
            LoginMessage loginMessage = JSON.parseObject(message, LoginMessage.class);
            String email = loginMessage.getMesMap().get("email");
            String username = loginMessage.getMesMap().get("username");
            MailUtils.sendMail(email, username);
            // System.err.println("消费消息:" + message);
        }
    }

}



