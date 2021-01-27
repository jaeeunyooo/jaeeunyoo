package com.jaeeunyoo.blog.domain.tag.application;

import com.jaeeunyoo.blog.config.cache.CacheKey;
import com.jaeeunyoo.blog.domain.post.entity.Post;
import com.jaeeunyoo.blog.domain.tag.dto.TagDto;
import com.jaeeunyoo.blog.domain.tag.entity.Tag;
import com.jaeeunyoo.blog.domain.tag.repository.TagRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<TagDto> getAllTags() {
        return TagDto.createMany(tagRepository.findByOrderByTagNameAsc());
    }

    @Cacheable(value = CacheKey.KEY_TRENDING_TAGS)
    public List<TagDto> getTrendingTags() {
        return TagDto.createMany(tagRepository.findAllByQuery());
    }

    public List<TagDto> getPostTags(Post post) {
        return TagDto.createMany(tagRepository.findByPostTagsIn(post.getPostTags()));
    }

    public void saveNewTags(List<String> tagNames) {
        if(tagNames != null && !tagNames.isEmpty()) {
            tagNames.forEach(tagName -> {
                Tag tag = tagRepository.findByTagNameEquals(tagName);
                if(tag == null) {
                    tagRepository.save(Tag.create(tagName));
                }
            });
        }
    }

    public List<Tag> getTagsByTagNames(List<String> tagNames) {
        return tagRepository.findByTagNameIn(tagNames);
    }
}
