package pl.damian.wasik.spring.app.club.web.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Club {
    private Long id;
    private String title;
    private String photoUrl;
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
