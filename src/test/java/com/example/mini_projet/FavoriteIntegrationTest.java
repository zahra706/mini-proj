package com.example.mini_projet;

import com.example.mini_projet.repository.FavoriteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FavoriteIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FavoriteRepository repository;

    @Test
    void testAddAndGetFavorite() throws Exception {
        String favoriteJson = "{\"userId\":\"user1\",\"courseId\":\"course1\"}";

        mockMvc.perform(post("/api/favorites")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(favoriteJson))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/api/favorites/user1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].courseId").value("course1"));
    }
}