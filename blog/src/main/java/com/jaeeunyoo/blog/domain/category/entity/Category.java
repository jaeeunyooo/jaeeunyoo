package com.jaeeunyoo.blog.domain.category.entity;

import com.jaeeunyoo.blog.domain.post.entity.Post;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Getter
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "upper_category_id", insertable = false, updatable = false)
    private Integer upperCategoryId;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Post> posts;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "upper_category_id")
    private Category upperCategory;

    @Builder.Default
    @OneToMany(mappedBy = "upperCategory", orphanRemoval = true)
    private List<Category> subCategories;

    public List<Category> getCategoriesIncludeUpperCategory() {
        List<Category> categories = new ArrayList<>();
        if(upperCategory != null) {
            categories.add(upperCategory);
        }
        categories.add(this);
        return categories;
    }
}
