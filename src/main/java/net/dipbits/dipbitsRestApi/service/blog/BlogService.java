package net.dipbits.dipbitsRestApi.service.blog;

import net.dipbits.dipbitsRestApi.dto.blog.BlogDTO;
import net.dipbits.dipbitsRestApi.dto.blog.NewBlogRequestDTO;

public interface BlogService {
    public BlogDTO createBlog(NewBlogRequestDTO newBlogRequestDTO);
}
