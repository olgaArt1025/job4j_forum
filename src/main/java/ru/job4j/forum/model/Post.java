package ru.job4j.forum.model;

import java.time.LocalDate;
import java.util.Objects;

public class Post {
    private int id;
    private String name;
    private String description;
    private LocalDate  created;

    public Post() {
    }

    public Post(int id, String name, String description, LocalDate  created) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public static Post of(String name) {
        Post post = new Post();
        post.name = name;
        return post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate  getCreated() {
        return created;
    }

    public void setCreated(LocalDate  created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id
                && Objects.equals(name, post.name)
                && Objects.equals(description, post.description)
                && Objects.equals(created, post.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, created);
    }
}
