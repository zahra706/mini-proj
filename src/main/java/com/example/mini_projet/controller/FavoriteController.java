package com.example.mini_projet.controller;

import com.example.mini_projet.model.Favorite;
import com.example.mini_projet.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteService service;

    @PostMapping
    public ResponseEntity<Favorite> addFavorite(@RequestBody Favorite favorite) {
        return ResponseEntity.status(201).body(service.addFavorite(favorite));
    }

    @DeleteMapping("/{userId}/{courseId}")
    public ResponseEntity<Void> removeFavorite(@PathVariable String userId, @PathVariable String courseId) {
        service.removeFavorite(userId, courseId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Favorite>> getFavorites(@PathVariable String userId) {
        return ResponseEntity.ok(service.getFavorites(userId));
    }
}