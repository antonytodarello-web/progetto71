package antoniotodarello.progetto70.dto;

import antoniotodarello.progetto70.entities.Role;
import lombok.Data;

@Data
public class RegisterRequest {

    private String name;
    private String email;
    private String password;
    private Role role; // USER oppure ORGANIZER
}
