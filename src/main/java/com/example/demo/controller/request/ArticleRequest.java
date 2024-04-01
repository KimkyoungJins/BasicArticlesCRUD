package com.example.demo.controller.request;


// 프론트 엔드에서 받아오는 form이라고 생각하면 된다. Controller 패키지 안에 있다.

/**
 * 프론트엔드에서 받아오는 form이다.
 * JPA 폼으로 전달 받는다고 할 수 있다.
 */

public class ArticleRequest {
    private String title;
    private String content;

    public ArticleRequest(String title, String content) {
        this.title = title;
        this.content = content;
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
}
