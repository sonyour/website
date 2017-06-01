package org.website.core.server.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.website.core.server.article.model.impl.Article;

public interface ArticleService extends  JpaRepository<Article, Integer> {
    
}
