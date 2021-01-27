package com.jaeeunyoo.blog.client;

import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA;

import java.io.IOException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
public class ToastImageClient {

    private static final String URL = "https://api-image.cloud.toast.com/image/v2.0/appkeys/{appKeys}/images?autorename=true&path={path}";

    private final String appKey;
    private final String secretKey;
    private final RestTemplate restTemplate;
    private final HttpHeaders uploadRequestHeaders;

    public ToastImageClient(String appKey, String secretKey, RestTemplate restTemplate) {
        this.appKey = appKey;
        this.secretKey = secretKey;
        this.restTemplate = restTemplate;
        this.uploadRequestHeaders = getUploadRequestHeaders();
    }

    public ToastImageFile uploadImage(MultipartFile multipartFile, String path) throws IOException {
        ByteArrayResource byteArrayResource = new ByteArrayResource(multipartFile.getBytes());
        HttpEntity<ByteArrayResource> requestEntity = new HttpEntity<>(byteArrayResource, uploadRequestHeaders);
        ResponseEntity<ToastImageUploadResponse> responseEntity = restTemplate.exchange(
            URL,
            PUT,
            requestEntity,
            ToastImageUploadResponse.class,
            appKey,
            path + UUID.randomUUID() + ".png");

        if(responseEntity.getBody() != null && responseEntity.getBody().getFile() != null) {
            return responseEntity.getBody().getFile();
        }

        return null;
    }

    private HttpHeaders getUploadRequestHeaders() {
        HttpHeaders uploadHttpHeaders = new HttpHeaders();
        uploadHttpHeaders.add("Authorization", secretKey);
        uploadHttpHeaders.setContentType(MULTIPART_FORM_DATA);
        return uploadHttpHeaders;
    }
}
