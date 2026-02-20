package antoniotodarello.progetto70.authorization;


import antoniotodarello.progetto70.entities.Role;
import antoniotodarello.progetto70.entities.User;
import antoniotodarello.progetto70.repository.UserRepository;
import antoniotodarello.progetto70.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder;
    private final JwtService jwt;

    public String register(String name, String email, String password, Role role){
        if(repo.findByEmail(email).isPresent())
            throw new RuntimeException("Email già registrata");

        User user = User.builder()
                .name(name)
                .email(email)
                .password(encoder.encode(password))
                .role(role)
                .build();

        repo.save(user);
        return jwt.generateToken(email);
    }

    public String login(String email, String password){
        User user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        if(!encoder.matches(password, user.getPassword()))
            throw new RuntimeException("Password errata");

        return jwt.generateToken(email);
    }
}
