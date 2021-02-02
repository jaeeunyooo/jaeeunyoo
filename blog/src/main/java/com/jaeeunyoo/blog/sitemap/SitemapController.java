package com.jaeeunyoo.blog.sitemap;

import com.jaeeunyoo.blog.domain.category.repository.CategoryRepository;
import com.jaeeunyoo.blog.domain.post.repository.PostRepository;
import com.jaeeunyoo.blog.domain.tag.repository.TagRepository;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SitemapController {

    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final CategoryRepository categoryRepository;

    @Value("${url}")
    private String url;

    @GetMapping("/sitemap")
    public XmlUrlSet siteMap() {
        XmlUrlSet xmlUrlSet = new XmlUrlSet();
        LocalDate now = LocalDate.now();
        postRepository.findAllByDeletedFalse().forEach(postIdGettable -> xmlUrlSet.addUrl(new XmlUrl(url + "/post/" + postIdGettable.getPostId(), now)));
        tagRepository.findAllBy().forEach(tagIdGettable -> xmlUrlSet.addUrl(new XmlUrl(url + "/tag/" + tagIdGettable.getTagId(), now)));
        categoryRepository.findAllBy().forEach(categoryIdGettable -> xmlUrlSet.addUrl(new XmlUrl(url + "/tag/" + categoryIdGettable.getCategoryId(), now)));
        xmlUrlSet.addUrl(new XmlUrl(url, now));
        xmlUrlSet.addUrl(new XmlUrl(url + "/about", now));
        xmlUrlSet.addUrl(new XmlUrl(url + "/tag", now));
        xmlUrlSet.addUrl(new XmlUrl(url + "/archive", now));
        xmlUrlSet.addUrl(new XmlUrl(url + "/category", now));
        return xmlUrlSet;
    }
}
