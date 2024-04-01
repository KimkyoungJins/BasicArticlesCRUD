package com.example.demo.controller;

import com.example.demo.controller.request.ArticleRequest;
import com.example.demo.controller.response.ArticleResponse;
import com.example.demo.domain.Article;
import com.example.demo.dto.ArticleDto;
import com.example.demo.servicse.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 등록, 전체보기, 삭제, 하나 세부보기, 수정에 대한 CRUD 기능구현 완료를 해야한다.
 */

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // 첫 번째로 등록?
    @PostMapping // 경로는 클래스 레벨의 @RequestMapping에서 복수형으로 지정하는 것이 좋습니다.
    public ResponseEntity<Article> createArticle(@RequestBody ArticleRequest articleRequest) {
        Article createdArticle =  articleService.createArticle(articleRequest);
        return new ResponseEntity<>(createdArticle, HttpStatus.CREATED);
    }

    // 특정 게시물 조회하기
    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleResponse> getAnArticle(@PathVariable Long articleId) {
        ArticleDto article = articleService.getArticle(articleId);
        ArticleResponse response = new ArticleResponse(article);
        return ResponseEntity.ok(response);
    }

    // 전체 게시물 조회 기능 추가
    @GetMapping
    public ResponseEntity<List<ArticleResponse>> getAllArticles() {
        List<ArticleDto> articles = articleService.getAllArticles();
        List<ArticleResponse> responses = articles.stream()
                .map(ArticleResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    // 네번째 특정 게시물 삭제하기
    @DeleteMapping("{articleId}")
    public ResponseEntity<ArticleResponse> deleteArticle(@PathVariable Long articleId) {
        articleService.deleteArticle(articleId);
        ArticleResponse response = new ArticleResponse(ArticleDto.builder().build());
        return ResponseEntity.ok(response);
    }

    // 특정 게시물 수정하기
    @PutMapping("{articleId}")
    public ResponseEntity<ArticleResponse> updateArticle(@PathVariable Long articleId, @RequestBody ArticleRequest articleRequest) {
        ArticleDto updatedArticle = articleService.updateArticle(articleId, articleRequest);
        ArticleResponse response = new ArticleResponse(updatedArticle);
        return ResponseEntity.ok(response);
    }


}
