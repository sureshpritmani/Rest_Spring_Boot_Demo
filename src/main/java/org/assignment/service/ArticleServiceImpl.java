package org.assignment.service;

import java.util.List;
import org.assignment.dao.ArticleDAO;
import org.assignment.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDAO articleDAO;
	
	@Override
	public Article getArticleById(int articleId) {
		Article obj = articleDAO.getArticleById(articleId);
		return obj;
	}	
	@Override
	public List<Article> getAllArticles(){
		return articleDAO.getAllArticles();
	}
	@Override
	public synchronized boolean addArticle(Article article){
                if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
    	            return false;
                } else {
    	            articleDAO.addArticle(article);
    	            return true;
                }
	}
	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}
	@Override
	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);
	}
}
