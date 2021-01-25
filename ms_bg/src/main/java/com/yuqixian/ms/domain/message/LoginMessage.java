package com.yuqixian.ms.domain.message;

import java.util.Map;

public class LoginMessage {

    private String type;// 消息类型
    private Map<String, String> mesMap;// 消息数据

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getMesMap() {
        return mesMap;
    }

    public void setMesMap(Map<String, String> mesMap) {
        this.mesMap = mesMap;
    }

    @Override
    public String toString() {
        return "LoginMessage{" +
                "type='" + type + '\'' +
                ", mesMap=" + mesMap +
                '}';
    }
}
