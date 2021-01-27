package com.jaeeunyoo.blog.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ToastImageFile {

    @JsonProperty("url")
    private String imageUrl;

    @JsonProperty("id")
    private String imageId;
}
