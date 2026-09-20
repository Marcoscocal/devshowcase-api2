package br.com.mmpj.devshowcase.model;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String comment;
    private int rating; // Ex: 1 a 5

    // Relacionamento N : 1 com Project
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public Feedback() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
}