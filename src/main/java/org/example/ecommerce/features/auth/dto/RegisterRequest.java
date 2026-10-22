package org.example.ecommerce.features.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.ecommerce.features.auth.role.Role;

public record RegisterRequest(
        @NotEmpty(message = "Full name is mandatory")
        @NotBlank(message = "Full name is mandatory")
        String fullName,

        @NotBlank(message = "Email is mandatory")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "Password is mandatory")
        String password,

        @NotNull(message = "Role is mandatory (CUSTOMER, CONSTRUCTOR, VENDOR)")
        Role role
) {
}
