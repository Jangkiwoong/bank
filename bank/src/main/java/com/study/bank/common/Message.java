package com.study.bank.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Message {
    private String message;
    private Object data;

    public static Message setSuccess(String message, Object data) {
        return new Message(message, data);
    }
}

