package com.codeup.blog.Controllers;

import com.codeup.blog.Posts.Post;
import com.codeup.blog.Posts.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository PostDao;
    public PostController(PostRepository PostDao) {
        this.PostDao = PostDao;
    }

    @GetMapping("/posts")
    public String all(Model model){

        Iterable<Post> posts = PostDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model){

        Post post = new Post(id, "Hello World!", "This is my first post about JavaScript, yay!" );
        model.addAttribute("post", post);
        return "posts/show";
    }
    @GetMapping("/posts/create")
    public String showForm(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ){
        Post post = new Post(title, body);
        PostDao.save(post);
        return "redirect:/posts";

    }

//    @GetMapping("/posts/random")
//    public String random(Model model) {
//        return "posts/show";
//    }

}
