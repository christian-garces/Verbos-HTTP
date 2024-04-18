package co.com.Garces.service.http.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Data
@ToString
public class FilmDTO {

        private String id;
        private String title;
        private String producer;
        private String duration;
        private String genre;
}
