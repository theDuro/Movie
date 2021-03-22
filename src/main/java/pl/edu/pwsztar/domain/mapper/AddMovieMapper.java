package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.CreateMovieDto;
import pl.edu.pwsztar.domain.dto.MovieDto;
import pl.edu.pwsztar.domain.entity.Movie;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddMovieMapper {

    public Movie CreateMovieDtoToMovieDto(CreateMovieDto createMovieDto) {

        Movie movie = new Movie();

        movie.setTitle(createMovieDto.getTitle());
        movie.setYear(createMovieDto.getYear());
        movie.setImage(createMovieDto.getImage());

        return movie;
    }
}
