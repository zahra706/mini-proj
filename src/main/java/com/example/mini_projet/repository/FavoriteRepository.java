package com.example.mini_projet.repository;

import com.example.mini_projet.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, String> {
    List<Favorite> findByUserId(String userId);
    void deleteByUserIdAndCourseId(String userId, String courseId);
}