package com.jaeeunyoo.blog.client;

import lombok.Data;

@Data
public class ToastImageHeader {

    private Boolean successful;
    private Integer resultCode;
    private String resultMessage;
}
