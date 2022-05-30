package com.example.restdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TitleRepository extends JpaRepository<Title, Integer> {
    @Query(value = "SELECT * FROM title ORDER BY user_rating DESC, num_ratings DESC LIMIT ?1", nativeQuery = true)
    List<Title> findAllByBestRating(int limit);
}
