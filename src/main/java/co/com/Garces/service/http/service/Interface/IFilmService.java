package co.com.Garces.service.http.service.Interface;

import co.com.Garces.service.http.dto.FilmDTO;
import org.springframework.http.HttpHeaders;

import java.util.List;

public interface IFilmService {
    FilmDTO getFilmById(String id);
    FilmDTO createFilm(FilmDTO filmDTO);
    FilmDTO updateFilm(FilmDTO filmDTO);
    List<FilmDTO> getAllFilms();
    void deleteFilm(String id);
    HttpHeaders getFilmHeaders(String id);
    HttpHeaders options();
    FilmDTO patchFilm(String id, FilmDTO filmDTO);

}
