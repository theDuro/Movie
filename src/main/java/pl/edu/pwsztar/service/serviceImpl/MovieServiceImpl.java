package pl.edu.pwsztar.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.CreateMovieDto;
import pl.edu.pwsztar.domain.dto.MovieDto;
import pl.edu.pwsztar.domain.entity.Movie;
import pl.edu.pwsztar.domain.mapper.AddMovieMapper;
import pl.edu.pwsztar.domain.mapper.MovieListMapper;
import pl.edu.pwsztar.domain.repository.MovieRepository;
import pl.edu.pwsztar.service.MovieService;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

    private final MovieRepository movieRepository;
    private final MovieListMapper movieListMapper;
    private final AddMovieMapper addMovieMapper;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository,
                            MovieListMapper movieListMapper,
                            AddMovieMapper addMovieMapper) {

        this.movieRepository = movieRepository;
        this.movieListMapper = movieListMapper;
        this.addMovieMapper = addMovieMapper;
    }

    @Override
    public List<MovieDto> findAll() {
        List<Movie> movies = movieRepository.findAll();
        return movieListMapper.mapToDto(movies);
    }

    @Override
    public void addMovie(CreateMovieDto createMovieDto) {
        Movie t = movieRepository.save(addMovieMapper.CreateMovieDtoToMovieDto(createMovieDto));
        System.out.println( "TEEEEST:" +  t.getMovieId());
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);

    }
}
