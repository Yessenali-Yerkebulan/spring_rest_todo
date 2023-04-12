package com.example.spring_todo.entity;


import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name="todo")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean completed;
    private String description;



    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

    public TodoEntity(){}

    public TodoEntity(Long id, String title, Boolean completed, UserEntity user) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
