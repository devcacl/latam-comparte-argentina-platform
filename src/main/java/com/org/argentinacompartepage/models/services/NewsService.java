package com.org.argentinacompartepage.models.services;

import com.org.argentinacompartepage.entities.NewsEntity;
import com.org.argentinacompartepage.entities.enums.NewsStatus;

import java.util.List;

public interface NewsService {
    List<NewsEntity> ListAll();

    NewsEntity findById(Long id);

    void save(NewsEntity news);

    void delete(Long id);

    List<NewsEntity> searchByTitle(String titulo);

    List<NewsEntity> listPublished();

    List<NewsEntity> listFeaturedPublished();

    List<NewsEntity> filterNews(String titulo, String categoria, NewsStatus estado, Long autorId, Long id);
}
