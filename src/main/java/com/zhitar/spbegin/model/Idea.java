package com.zhitar.spbegin.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ideas")
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String caption;

    @Column(unique = true, nullable = false, columnDefinition = "text")
    private String content;

    @Column
    private long likes;

    @Column
    private long dislikes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public long getDislikes() {
        return dislikes;
    }

    public void setDislikes(long dislikes) {
        this.dislikes = dislikes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Idea idea = (Idea) o;
        return likes == idea.likes &&
                dislikes == idea.dislikes &&
                Objects.equals(caption, idea.caption) &&
                Objects.equals(content, idea.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caption, content, likes, dislikes);
    }

    @Override
    public String toString() {
        return "Idea{" +
                "id=" + id +
                ", caption='" + caption + '\'' +
                ", content='" + content + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                '}';
    }
}
