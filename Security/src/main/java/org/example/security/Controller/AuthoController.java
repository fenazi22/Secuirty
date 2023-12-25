package org.example.security.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.security.Model.User;
import org.example.security.Repository.AtuhRepository;
import org.example.security.Service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/autho")
@RequiredArgsConstructor
public class AuthoController {
private  final AuthService authService;

private ResponseEntity register(@RequestBody @Valid User user){
    authService.register(user);
    return ResponseEntity.status(200).body("User register");
}
}
