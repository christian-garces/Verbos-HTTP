package co.com.Garces.service.http.controller;

import co.com.Garces.service.http.dto.FilmDTO;
import co.com.Garces.service.http.service.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/film")
@RestController
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFilmById(@PathVariable String id) {
        return handle(() -> filmService.getFilmById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createFilm(@RequestBody FilmDTO filmDTO) {
        return handle(() -> filmService.createFilm(filmDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFilm(@PathVariable String id, @RequestBody FilmDTO filmDTO) {
        return handle(() -> filmService.updateFilm(id, filmDTO));
    }

    @GetMapping
    public ResponseEntity<?> getAllFilms() {
        return handle(filmService::getAllFilms);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFilm(@PathVariable String id) {
        return handle(() -> {
            filmService.deleteFilm(id);
            return null;
        });
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.HEAD)
    public ResponseEntity<?> getFilmHeaders(@PathVariable String id) {
        return handle(() -> filmService.getFilmHeaders(id));
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> options() {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchFilm(@PathVariable String id, @RequestBody FilmDTO filmDTO) {
        return handle(() -> filmService.patchFilm(id, filmDTO));
    }

    private ResponseEntity<?> handle(ServiceFunction serviceFunction) {
        try {
            return ResponseEntity.ok(serviceFunction.apply());
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    interface ServiceFunction {
        Object apply() throws NotFoundException, Exception;
    }
}
