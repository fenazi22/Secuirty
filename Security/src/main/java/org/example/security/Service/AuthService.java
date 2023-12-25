package org.example.security.Service;

import lombok.RequiredArgsConstructor;
import org.example.security.Model.User;
import org.example.security.Repository.AtuhRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthService {

    private final AtuhRepository atuhRepository;

    public void register(User user) {
        user.setRole("USER");
        String hash = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hash);
        atuhRepository.save(user);
    }
}
