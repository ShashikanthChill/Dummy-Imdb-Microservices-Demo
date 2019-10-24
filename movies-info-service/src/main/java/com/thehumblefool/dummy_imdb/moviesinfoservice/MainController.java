package com.thehumblefool.dummy_imdb.moviesinfoservice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    MovieService service;

    @RequestMapping(path = "/api/movie")
    public List<MovieDTO> movieHandler(@RequestParam Map<String, String> filterParams) {        //return movies based on request params
        String filterParam = filterParams.keySet().iterator().next().trim();
        switch (filterParam) {
        case "name": {      //return movie based on name
            return service.loadMovieByName(filterParams.get(filterParam));
        }

        case "year": {      //return movies based on year
            try {
                return service.loadMoviesByYear(Long.parseLong(filterParams.get(filterParam)));
            } catch (NumberFormatException nfe) {
                throw new RequestParamFormatException(
                        "Unsupported value found for 'year'=`" + filterParams.get(filterParam));
            }
        }

        case "lang": {      //return movie based on language
            return service.loadMoviesByLanguage(filterParams.get(filterParam));
        }

        default:
            throw new InvalidRequestParamException("Invalid request parameter: '" + filterParam + "'.");
        }
    }
}