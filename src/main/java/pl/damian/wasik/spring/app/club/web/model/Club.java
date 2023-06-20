package pl.damian.wasik.spring.app.club.web.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Club {
    private Long id;
    @NotEmpty(message = "Club title should not be empty")
    private String title;
    @NotEmpty(message = "Photo link should not be empty")
    private String photoUrl;
    @NotEmpty(message = "Content should not be empty")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
