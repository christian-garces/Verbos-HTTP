package co.com.Garces.service.http.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Document(collection = "films")
public class Film {

    @Id
    private String id;
    private String title;
    private String producer;
    private String duration;
    private String genre;

}
