// package com.thehumblefool.dummy_imdb.moviescatalogservice;

// import org.springframework.stereotype.Component;

// import feign.Response;
// import feign.codec.ErrorDecoder;

// @Component
// public class MovieInfoErrorDecoder implements ErrorDecoder {

//     @Override
//     public Exception decode(String methodKey, Response response) {
//         System.out.println("decoding fe. MethodKey: " + methodKey);
//         System.out.println("decoding fe. Response body: " + response.body());
//         if (response.status() == 404) {
//             System.out.println("movie not found for: " + response.request().url());
//             return new RuntimeException("Movie not found.");
//         } else {
//             return new RuntimeException(response.reason());
//         }
//     }

// }