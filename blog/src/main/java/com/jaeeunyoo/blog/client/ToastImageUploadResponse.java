package com.jaeeunyoo.blog.client;

import lombok.Data;

@Data
public class ToastImageUploadResponse {

    private ToastImageHeader header;
    private ToastImageFile file;
}
