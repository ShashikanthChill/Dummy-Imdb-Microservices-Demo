package com.thehumblefool.dummy_imdb.moviescatalogservice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import feign.FeignException;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class MainController {

    // @Autowired
    // RestTemplate rest;
    @Autowired
    MoviesInfoClient infoClient;

    @Autowired
    MoviesRatingClient ratingClient;

    @Autowired
    MoviesCommentClient commentClient;

    @RequestMapping(path = "/api/movie")
    public List<MovieCatalogDTO> movieHandler(@RequestParam Map<String, String> filterParams) { // return movies based

        try {
            List<MovieInfoDTO> moviesByName = infoClient.getMovieByName("Baahubali");
            List<MovieCatalogDTO> catalogDTOs = moviesByName.stream()
                    .map((MovieInfoDTO info) -> new MovieCatalogDTO(info.getMovieId(), info.getMoviename(),
                    info.getDesc(), info.getLang(), info.getYear(), null))
                    .collect(Collectors.toList());
            System.out.println("MovieCatalogs: " + catalogDTOs);
//            catalogDTOs.stream().map((MovieCatalogDTO catalogDTO) -> {
//                try {
//                    List<RatingDTO> ratingsByMovie = ratingClient.getRatingsByMovie(catalogDTO.getMovieId());
//                    List<RatingAndCommentDTO> ratingAndCommentDTOs = ratingsByMovie.stream().map((rating) -> {
//                        return new RatingAndCommentDTO(rating.getUserId(), rating.getRating(), null);
//                    }).collect(Collectors.toList());
//                } catch (FeignException fes) {
//                    System.out.println(fes.status());
//                    System.out.println("content utf-8: " + fes.contentUTF8());
//                    throw fes;
//                }
//            });
            Map<Long, List<RatingDTO>> ratingsMap = new HashMap<>();
            catalogDTOs.forEach((t) -> {
                try {
                    List<RatingDTO> ratingsByMovie = ratingClient.getRatingsByMovie(t.getMovieId());
                    System.out.println("Ratings by movie: " + ratingsByMovie);
                    ratingsMap.put(t.getMovieId(), ratingsByMovie);
                } catch (FeignException fe) {
                    System.out.println(fe.status());
                    System.out.println("content utf-8: " + fe.contentUTF8());
                    ratingsMap.put(t.getMovieId(), new ArrayList<>());
                }
            });
            Map<Long, List<CommentDTO>> commentsMap = new HashMap<>();
            catalogDTOs.forEach((t) -> {
                try {
                    List<CommentDTO> commentsByMovie = commentClient.getCommentsByMovie(t.getMovieId());
                    System.out.println("Comments by movie: " + commentsByMovie);
                    commentsMap.put(t.getMovieId(), commentsByMovie);
                } catch (FeignException fe) {
                    System.out.println(fe.status());
                    System.out.println("content utf-8: " + fe.contentUTF8());
                    ratingsMap.put(t.getMovieId(), new ArrayList<>());
                }
            });

//            List<List<RatingAndCommentDTO>> listOfRatingAndCommentDTOList = catalogDTOs.stream().map((t) -> {
//                List<RatingDTO> ratings = ratingsMap.get(t.getMovieId());
//                List<CommentDTO> comments = commentsMap.get(t.getMovieId());
//                if (ratings == null && comments == null) {
//                        continue;
//                    }
//                List<RatingAndCommentDTO> ratingAndCommentDTOs = new ArrayList<>();
//                for (int i = 0; i < ratings.size(); i++) {
//                    ratingAndCommentDTOs.add(new RatingAndCommentDTO(ratings.get(i).getUserId(), ratings.get(i).getRating(), comments.get(i).getComment()));
//                }
//                return ratingAndCommentDTOs;
//            }).collect(Collectors.toList());
            catalogDTOs.forEach((t) -> {
                List<RatingDTO> ratings = ratingsMap.get(t.getMovieId());
                List<CommentDTO> comments = commentsMap.get(t.getMovieId());
                if (ratings == null && comments == null) {
                    return;
                }
                List<RatingAndCommentDTO> ratingAndCommentDTOs = new ArrayList<>();
                if (ratings == null && comments != null) {
                    for (int i = 0; i < comments.size(); i++) {
                        ratingAndCommentDTOs.add(new RatingAndCommentDTO(comments.get(i).getUserId(), 0.00, comments.get(i).getComment()));
                    }
                } else if (comments == null && ratings != null) {
                    for (int i = 0; i < ratings.size(); i++) {
                        ratingAndCommentDTOs.add(new RatingAndCommentDTO(ratings.get(i).getUserId(), ratings.get(i).getRating(), null));
                    }
                }

                t.setRatingAndComments(ratingAndCommentDTOs);
            });

//            assert (catalogDTOs.size() == listOfRatingAndCommentDTOList.size());
//            for (int i = 0; i < catalogDTOs.size(); i++) {
//                catalogDTOs.get(i).setRatingAndComments(listOfRatingAndCommentDTOList.get(i));
//            }
            return catalogDTOs;

        } catch (FeignException fe) {
            System.out.println(fe.status());
            System.out.println("content utf-8: " + fe.contentUTF8());
            throw fe;
        }
    }
}
