package co.com.Garces.service.http.service;

import co.com.Garces.service.http.dto.FilmDTO;
import co.com.Garces.service.http.mapper.FilmMapper;
import co.com.Garces.service.http.model.Film;
import co.com.Garces.service.http.repository.FilmRepository;
import co.com.Garces.service.http.service.Interface.IFilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpHeaders;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService implements IFilmService {

    private final FilmRepository filmRepository;
    @Override
    public FilmDTO getFilmById(String id) {
        return FilmMapper.domainToDTO(filmRepository.findById(id).get());

    }
    @Override
    public FilmDTO createFilm(FilmDTO filmDTO) {
        Film film = FilmMapper.createDtoToDomain(filmDTO);
        return FilmMapper.domainToDTO(filmRepository.save(film));
    }
    @Override
    public FilmDTO updateFilm(FilmDTO filmDTO) {
        Film film = FilmMapper.updateDtoToDomain(filmDTO);
        return FilmMapper.domainToDTO(filmRepository.save(film));
    }

    @Override
    public List<FilmDTO> getAllFilms() {
        return FilmMapper.domainToDTOList(filmRepository.findAll());
    }
    @Override
    public void deleteFilm(String id) {
        filmRepository.delete(filmRepository.findById(id).get());
    }

    @Override
    public HttpHeaders getFilmHeaders(String id) {
        HttpHeaders httpHeaders = new HttpHeaders();

        if (filmRepository.existsById(id)) {
            Film film = filmRepository.findById(id).get();
            httpHeaders.add("Film_Name", film.getTitle());
            httpHeaders.add("Film_Genre", film.getGenre());
        }

        return httpHeaders;

    }
    @Override
    public HttpHeaders options() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Allow", "GET, POST, DELETE, OPTIONS, PUT, PATCH, HEAD");
        httpHeaders.add("Access-Control-Allow-Methods", "GET, POST, DELETE, OPTIONS, PUT, PATCH, HEAD");
        return httpHeaders;
    }


    private void validatePatchFilm(String id, FilmDTO filmDTO) {
        if (!filmRepository.existsById(id)) {
            throw new RuntimeException("Film not found");
        }

        Film film = filmRepository.findById(id).get();

        if (filmDTO.getTitle() != null) {
            film.setTitle(filmDTO.getTitle());
        }

        if (filmDTO.getProducer() != null) {
            film.setProducer(filmDTO.getProducer());
        }

        if (filmDTO.getDuration() != null) {
            film.setDuration(filmDTO.getDuration());
        }

        if (filmDTO.getGenre() != null) {
            film.setGenre(filmDTO.getGenre());
        }

    }
    @Override
    public FilmDTO patchFilm(String id, FilmDTO filmDTO) {
        validatePatchFilm(id, filmDTO);
        return FilmMapper.domainToDTO(filmRepository.save(FilmMapper.updateDtoToDomain(filmDTO)));
    }


}
