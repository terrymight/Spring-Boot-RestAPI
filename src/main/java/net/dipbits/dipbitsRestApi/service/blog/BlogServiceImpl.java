package net.dipbits.dipbitsRestApi.service.blog;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dipbits.dipbitsRestApi.dto.blog.BlogConverter;
import net.dipbits.dipbitsRestApi.dto.blog.BlogDTO;
import net.dipbits.dipbitsRestApi.dto.blog.NewBlogRequestDTO;
import net.dipbits.dipbitsRestApi.model.Blog;
import net.dipbits.dipbitsRestApi.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private BlogConverter blogConverter;
    @Override
    public BlogDTO createBlog(NewBlogRequestDTO requestDTO) {
        log.info("createBlog started");

        Blog nblog = new Blog();

        nblog.setTitle(requestDTO.getTitle());

        nblog.setBody(requestDTO.getBody());

        nblog.setCreatedAt(LocalDateTime.now());

        nblog.setUpdatedAt(LocalDateTime.now());

        nblog = blogRepository.save(nblog);

        log.info("createBlog before save id"+nblog.getId());

        return blogConverter.convertBlogtoBlogDTO(nblog);

    }
}
