package ru.job4j.forum.repository;


import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Collection;

@Repository
public class PostMem {
    private static final PostMem INST = new PostMem();
    private final AtomicInteger number = new AtomicInteger();
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    public PostMem() {
        posts.put(1, new Post(1, "Продаю машину ладу 01.", "Text1",
                LocalDate.of(2022, 4, 1)));
        posts.put(2, new Post(2, "Продаю машину ладу 02.", "Text2",
                LocalDate.of(2022, 5, 1)));
    }

    public static PostMem instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public Post findById(Integer id) {
        return posts.get(id);
    }

    public void create(Post post) {
        if (post.getId() == 0) {
            post.setId(number.incrementAndGet());
        }
        post.setCreated(LocalDate.now());
        posts.put(post.getId(), post);
    }

    public void update(Post post) {
        posts.replace(post.getId(), post);
        post.setCreated(LocalDate.now());
    }
}
