package net.dipbits.dipbitsRestApi.dto.blog;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBlogDTO {

    @NotNull(message = "Title can`t be null")
    @NotBlank(message = "Title can`t be blank")
    private String title;

    //@Size(min=2, max=30)
    @NotNull(message = "Title can`t be null")
    @NotBlank(message = "Title can`t be blank")
    private String body;

    LocalDateTime updatedAt;
}
