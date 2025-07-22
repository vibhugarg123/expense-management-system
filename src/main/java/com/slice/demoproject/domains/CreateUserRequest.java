package com.slice.demoproject.domains;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateUserRequest {
  @NotBlank private String name;

  @NotBlank @Email private String email;

  @NotBlank
  @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
  private String phoneNumber;

  @NotBlank
  @Pattern(
      regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
      message =
          "Password must be at least 8 characters long and include uppercase, lowercase, digit, and special character")
  private String password;
}
