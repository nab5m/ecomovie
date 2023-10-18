package kr.ecocow.ecomovie.service;

import kr.ecocow.ecomovie.dto.MovieDetailsDTO;
import kr.ecocow.ecomovie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public @Nullable MovieDetailsDTO getMovieDetails(Long movieId) {
        return movieRepository.findMovieDetails(movieId);
    }
}
