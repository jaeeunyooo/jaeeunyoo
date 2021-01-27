package com.jaeeunyoo.blog.domain.image;

import com.jaeeunyoo.blog.client.ToastImageClient;
import com.jaeeunyoo.blog.client.ToastImageFile;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/image")
public class ImageRestController {

    private final ToastImageClient toastImageClient;

    @PostMapping
    public ToastImageFile upload(@RequestParam("imageFile") MultipartFile multipartFile) throws IOException {
        return toastImageClient.uploadImage(multipartFile, "/jaeeunyoo/blog/");
    }
}
