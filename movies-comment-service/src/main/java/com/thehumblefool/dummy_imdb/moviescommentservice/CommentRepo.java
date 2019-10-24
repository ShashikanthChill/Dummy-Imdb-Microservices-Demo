package com.thehumblefool.dummy_imdb.moviescommentservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CommentRepo extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByUserId(long userId);

    List<CommentEntity> findByMovieId(long movieId);

    long countByMovieId(long movieId);

    Optional<CommentEntity> findByUserIdAndMovieId(long userId, long movieId);
}