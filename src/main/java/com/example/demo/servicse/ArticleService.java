package com.example.demo.servicse;

import com.example.demo.controller.request.ArticleRequest;
import com.example.demo.domain.Article;
import com.example.demo.dto.ArticleDto;
import com.example.demo.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {

    // service는 repository에 접근한다.
    private final ArticleRepository articleRepository;

    public Article createArticle(ArticleRequest articleRequest){
        Article article = new Article();
        article.setTitle(articleRequest.getTitle());
        article.setContent(articleRequest.getContent());
        return articleRepository.save(article); // 레포로 엔티티를 디비에 저장한다.
    }

    public ArticleDto getArticle(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("Article not found with id: " + articleId));
        return ArticleDto.from(article);
    }

    public void deleteArticle(Long articleId) {
        articleRepository.deleteById(articleId);
    }

    public List<ArticleDto> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }

    public ArticleDto updateArticle(Long articleId, ArticleRequest articleRequest) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("Article not found with id: " + articleId));
        article.setTitle(articleRequest.getTitle());
        article.setContent(articleRequest.getContent());
        articleRepository.save(article);
        return ArticleDto.from(article);
    }

}
