package org.example.ecommerce.features.auth.service;

import lombok.RequiredArgsConstructor;
import org.example.ecommerce.features.auth.dto.AuthResponse;
import org.example.ecommerce.features.auth.dto.LoginRequest;
import org.example.ecommerce.features.auth.dto.RegisterRequest;
import org.example.ecommerce.features.auth.model.User;
import org.example.ecommerce.features.auth.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request){
        User user = User.builder()
                .fullName(request.fullName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role())
                .active(true)
                .build();

        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user);

        return new AuthResponse(
                jwtToken,
                user.getEmail(),
                user.getRole().name(),
                user.getFullName()
        );
    }

    public AuthResponse authenticate(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String jwtToken = jwtService.generateToken(user);

        return new AuthResponse(jwtToken, user.getEmail(), user.getRole().name(), user.getFullName());
    }
}
