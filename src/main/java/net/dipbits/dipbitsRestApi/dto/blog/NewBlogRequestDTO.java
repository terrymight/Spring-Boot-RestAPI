package net.dipbits.dipbitsRestApi.dto.blog;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;


@Data
public class NewBlogRequestDTO {

    @Valid

    @NotNull(message = "Title can`t be null")
    @NotBlank(message = "Title can`t be blank")
    private String title;

    @NotNull(message = "Body can`t be null")
    @NotBlank(message = "Body can`t be blank")
    private String body;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
