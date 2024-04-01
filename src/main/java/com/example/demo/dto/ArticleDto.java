package com.example.demo.dto;

import com.example.demo.domain.Article;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * dto 클래스들의 역할은 계층간의 데이터 교환을 위해서 사용된다고 볼 수 있다.
 * 클라이언트로부터 받은 데이터를 서비스 계층에 전달한다고 볼 수 있다.
 * builder를 사용해서 가독성과 유지 보수성을 높인다고 볼 수 있다.
 */


@Getter
@Setter
@Builder
public class ArticleDto {
    private String title;
    private String content;
    private Long id;

    public static ArticleDto from(Article article) {
        return ArticleDto.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .id(article.getId())
                .build();
    }

    public ArticleDto(String title, String content, Long id) {
        this.title = title;
        this.content = content;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}