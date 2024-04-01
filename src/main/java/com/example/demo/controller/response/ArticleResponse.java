package com.example.demo.controller.response;

import com.example.demo.dto.ArticleDto;
import lombok.Getter;

@Getter     // 이거 추가하니까 되더라
public class ArticleResponse {
    private String title;
    private String content;

    public ArticleResponse(ArticleDto article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }




}
