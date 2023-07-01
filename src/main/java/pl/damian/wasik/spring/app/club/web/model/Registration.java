package pl.damian.wasik.spring.app.club.web.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Registration {
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
