package org.assignment.service;

import java.util.List;
import org.assignment.entity.Article;

public interface ArticleService {
     List<Article> getAllArticles();
     Article getArticleById(int articleId);
     boolean addArticle(Article article);
     void updateArticle(Article article);
     void deleteArticle(int articleId);
}