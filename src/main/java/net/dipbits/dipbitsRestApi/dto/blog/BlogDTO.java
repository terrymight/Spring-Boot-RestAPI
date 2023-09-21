package net.dipbits.dipbitsRestApi.dto.blog;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogDTO {
    private Long id;
    private String title;
    private String body;
    LocalDateTime updatedAt;
    LocalDateTime createdAt;
}
