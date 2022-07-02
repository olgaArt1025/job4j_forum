package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;

    }

    public Post findById(Integer id) {
        return posts.findById(id).orElse(null);
    }

    public void create(Post post) {
        post.setCreated(LocalDate.now());
        posts.save(post);
    }

    public void update(Post post) {
        post.setCreated(LocalDate.now());
        posts.save(post);
    }
}
