package antoniotodarello.progetto70.controller;


import antoniotodarello.progetto70.authorization.AuthService;
import antoniotodarello.progetto70.dto.LoginRequest;
import antoniotodarello.progetto70.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    // 🔹 registrazione utente
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest req) {
        return service.register(
                req.getName(),
                req.getEmail(),
                req.getPassword(),
                req.getRole()
        );
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {
        return service.login(
                req.getEmail(),
                req.getPassword()
        );
    }
}
