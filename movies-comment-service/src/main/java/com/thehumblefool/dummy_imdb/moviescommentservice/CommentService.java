package com.thehumblefool.dummy_imdb.moviescommentservice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepo repo;

    public List<CommentDTO> loadCommentsByUser(long userId) {
        List<CommentEntity> ratingsByUserId = repo.findByUserId(userId);
        if (ratingsByUserId.isEmpty())
            throw new CommentNotFoundException("No comments found by userId: " + userId);
        return mapCommentEntityToDTO(ratingsByUserId);
    }

    public List<CommentDTO> loadCommentsByMovie(long movieId) {
        List<CommentEntity> ratingsByMovie = repo.findByMovieId(movieId);
        if (ratingsByMovie.isEmpty())
            throw new CommentNotFoundException("No comments found for movieId: " + movieId);
        return mapCommentEntityToDTO(ratingsByMovie);
    }

    public long loadCommentCountByMovie(long movieId) {
        return repo.countByMovieId(movieId);
    }

    public List<CommentDTO> loadCommentByUserOfMovie(long userId, long movieId) {
        Optional<CommentEntity> ratingByUserIdOfMovieId = repo.findByUserIdAndMovieId(userId, movieId);
        return mapCommentEntityToDTO(Arrays.asList(new CommentEntity[]{ratingByUserIdOfMovieId.orElseThrow(() -> new CommentNotFoundException("No comments found for movieId: " + movieId + " by userId: " + userId))}));
    }

    private List<CommentDTO> mapCommentEntityToDTO(List<CommentEntity> commentEntities) {
        return commentEntities.stream().map(e -> new CommentDTO(e.getUserId(), e.getMovieId(), e.getComment()))
                .collect(Collectors.toList());
    }
}
