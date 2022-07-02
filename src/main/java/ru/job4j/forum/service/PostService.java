package ru.job4j.forum.service;


import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostMem;

import java.util.Collection;

@Service
public class PostService {
    private  final PostMem store = PostMem.instOf();

    public Collection<Post> getAll() {
        return store.findAll();
    }

    public Post findById(Integer id) {
        return store.findById(id);
    }

    public void create(Post post) {
        store.create(post);
    }

    public void update(Post post) {
        store.update(post);
    }
}
