package pl.edu.pwsztar.service;

import pl.edu.pwsztar.domain.dto.CreateMovieDto;
import pl.edu.pwsztar.domain.dto.MovieDto;
import pl.edu.pwsztar.domain.entity.Movie;

import java.util.List;

public interface MovieService {

    List<MovieDto> findAll();
    void addMovie(CreateMovieDto createMovieDto);
    void deleteMovie(Long id);
}
