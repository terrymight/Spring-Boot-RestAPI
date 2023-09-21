package net.dipbits.dipbitsRestApi.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import net.dipbits.dipbitsRestApi.dto.blog.BlogDTO;
import net.dipbits.dipbitsRestApi.dto.blog.NewBlogRequestDTO;
import net.dipbits.dipbitsRestApi.service.blog.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/v1/blog")
public class BlogController {

    @Autowired
    private BlogServiceImpl blogService;

    @PostMapping
    public ResponseEntity<?> createBlog(
            @Valid @RequestBody NewBlogRequestDTO nRequestDTO,
            UriComponentsBuilder uComBuilder,
            BindingResult bindingResult) {
        log.debug("create new blog request - {} " + nRequestDTO);
        BlogDTO blogDTO = blogService.createBlog(nRequestDTO);

        URI saveLocation = uComBuilder
                .path("/api/v1/blog/{id}")
                .buildAndExpand(blogDTO.getId())
                .toUri();
        log.debug("created new blog successful");

        return ResponseEntity.created(saveLocation).build();
        // ResponseEntity.status(HttpStatus.CREATED).body(blogDTO);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }
}