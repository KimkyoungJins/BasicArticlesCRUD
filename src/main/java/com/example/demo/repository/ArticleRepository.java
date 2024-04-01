package com.example.demo.repository;

import com.example.demo.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository는 Service에서 domain으로 보내기 위해서 data 형태를 바꿔주는 것이라고 할 수 있다.
 * JpaRepository를 상속받아서 사용한다.

 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {



}
