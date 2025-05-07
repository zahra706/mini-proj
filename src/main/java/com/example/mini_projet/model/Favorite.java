package com.example.mini_projet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Favorite {
    @Id
    private String id;
    private String userId;
    private String courseId;
}