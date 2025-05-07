package com.example.mini_projet.service;

import com.example.mini_projet.model.Favorite;
import com.example.mini_projet.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository repository;

    @CacheEvict(value = "favorites", key = "#favorite.userId")
    public Favorite addFavorite(Favorite favorite) {
        return repository.save(favorite);
    }

    @CacheEvict(value = "favorites", key = "#userId")
    public void removeFavorite(String userId, String courseId) {
        repository.deleteByUserIdAndCourseId(userId, courseId);
    }

    @Cacheable(value = "favorites", key = "#userId")
    public List<Favorite> getFavorites(String userId) {
        return repository.findByUserId(userId);
    }
}