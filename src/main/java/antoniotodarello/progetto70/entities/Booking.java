package antoniotodarello.progetto70.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int seatsReserved;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;
}
