package com.example.mini_projet.service;

import com.example.mini_projet.model.Favorite;
import com.example.mini_projet.repository.FavoriteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FavoriteServiceTest {
    @Mock
    private FavoriteRepository repository;

    @InjectMocks
    private FavoriteService service;

    @Test
    void testGetFavorites() {
        Favorite favorite = new Favorite();
        favorite.setUserId("user1");
        favorite.setCourseId("course1");
        List<Favorite> favorites = Arrays.asList(favorite);

        when(repository.findByUserId("user1")).thenReturn(favorites);

        List<Favorite> result = service.getFavorites("user1");
        assertEquals(1, result.size());
        assertEquals("course1", result.get(0).getCourseId());
        verify(repository, times(1)).findByUserId("user1");
    }
}