package com.yuqixian.ms.message.kafka;

import com.alibaba.fastjson.JSON;
import com.yuqixian.ms.domain.message.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class LoginProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 发送数据
     * @param email
     * @param username
     */
    public void produceMessage(String email, String username) {
        LoginMessage lm = new LoginMessage();
        lm.setType("email");
        Map<String, String> map = new HashMap<String, String>();
        map.put("email", email);
        map.put("username", username);
        lm.setMesMap(map);
        // System.err.println("发送登录提示:" + lm);
        kafkaTemplate.send("ms", JSON.toJSONString(lm));

    }
}