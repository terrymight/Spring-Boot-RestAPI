package net.dipbits.dipbitsRestApi.repository;

import net.dipbits.dipbitsRestApi.model.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog,Long> {
}
