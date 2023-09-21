package net.dipbits.dipbitsRestApi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(length = 50000)
    private String body;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}
