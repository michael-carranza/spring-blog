package com.codeup.blog.Posts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository <Post, Long> {
    @Query(value="SELECT * FROM posts ORDER BY RAND() LIMIT 1", nativeQuery=true)
    Post getRandom();
}
