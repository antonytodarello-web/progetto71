package antoniotodarello.progetto70.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime date;
    private String location;
    private int availableSeats;

    @ManyToOne
    @JoinColumn(name="creator_id")
    private User creator;
}
