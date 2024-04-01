package com.example.demo.domain;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity     // 이게 Entity 클래스인 것은 스프링 부트에게 알려준다.
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;

    private String content;

    public Article() {
        this.id = id;
        this.title = getTitle();
        this.content = getContent();
    }

}
