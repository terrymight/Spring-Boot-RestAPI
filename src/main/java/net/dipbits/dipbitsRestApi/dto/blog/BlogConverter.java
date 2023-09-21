package net.dipbits.dipbitsRestApi.dto.blog;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.dipbits.dipbitsRestApi.model.Blog;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@AllArgsConstructor
public class BlogConverter {

    private ModelMapper mapper = new ModelMapper();

    public BlogDTO convertBlogtoBlogDTO(Blog blog) {
        // log.debug("something is wrong here");
        BlogDTO blogDTO;
        blogDTO = mapper.map(blog, BlogDTO.class);

        return blogDTO;
    }

    public Blog convertBlogDTOtoBlog(BlogDTO blogDTO) {
        Blog blog;
        blog = mapper.map(blogDTO, Blog.class);
        return blog;
    }
}
