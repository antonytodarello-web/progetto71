package antoniotodarello.progetto70.controller;

import antoniotodarello.progetto70.authorization.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest req){
        return service.register(req.getName(), req.getEmail(), req.getPassword(), req.getRole());
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req){
        return service.login(req.getEmail(), req.getPassword());
    }
}
