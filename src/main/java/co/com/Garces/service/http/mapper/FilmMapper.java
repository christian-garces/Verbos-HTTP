package co.com.Garces.service.http.mapper;

import co.com.Garces.service.http.dto.FilmDTO;
import co.com.Garces.service.http.model.Film;
import co.com.Garces.service.*;

import java.util.List;
import java.util.stream.Collectors;

public class FilmMapper {
    public static FilmDTO domainToDTO(Film film) {
        return new FilmDTO(film.getId(), film.getTitle(), film.getProducer(), film.getDuration(), film.getGenre());
    }

    public static List<FilmDTO> domainToDTOList(List<Film> films) {
        return films.stream()
                    .map(FilmMapper::domainToDTO)
                    .collect(Collectors.toList());
    }

    public static Film dtoToDomain(FilmDTO filmDTO) {
        return new Film(filmDTO.getId(), filmDTO.getTitle(), filmDTO.getProducer(), filmDTO.getDuration(), filmDTO.getGenre());
    }
}