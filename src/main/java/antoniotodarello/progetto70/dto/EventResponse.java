package antoniotodarello.progetto70.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EventResponse {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime date;
    private String location;
    private int availableSeats;
    private String creatorName;
}
