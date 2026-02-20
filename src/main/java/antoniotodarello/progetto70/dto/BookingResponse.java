package antoniotodarello.progetto70.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingResponse {

    private Long bookingId;
    private String eventTitle;
    private int seatsReserved;
}
