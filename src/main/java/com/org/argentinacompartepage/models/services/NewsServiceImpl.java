package com.org.argentinacompartepage.models.services;

import com.org.argentinacompartepage.entities.NewsEntity;
import com.org.argentinacompartepage.entities.enums.NewsStatus;
import com.org.argentinacompartepage.models.daos.NewsDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsDao newsDao;

    public NewsServiceImpl(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public List<NewsEntity> ListAll() {
        return newsDao.findAll();
    }

    @Override
    public NewsEntity findById(Long id) {
        return newsDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Noticia no encontrada"));
    }

    @Override
    public void save(NewsEntity news) {
        newsDao.save(news);
    }

    @Override
    public void delete(Long id) {
        newsDao.deleteById(id);
    }

    @Override
    public List<NewsEntity> searchByTitle(String titulo) {
        return newsDao.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<NewsEntity> listPublished() {
        return newsDao.findByEstado(NewsStatus.PUBLICADO);
    }

    @Override
    public List<NewsEntity> listFeaturedPublished() {
        return newsDao.findByDestacadaTrueAndEstado(NewsStatus.PUBLICADO);
    }

    @Override
    public List<NewsEntity> filterNews(String titulo, String categoria, NewsStatus estado, Long autorId, Long id) {
        return newsDao.filterNews(titulo, categoria, estado, autorId, id);
    }
}
