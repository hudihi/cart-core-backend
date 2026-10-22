package org.example.ecommerce.features.auth.dto;

public record AuthResponse(
        String token,
        String email,
        String role,
        String fullName
) {
}
