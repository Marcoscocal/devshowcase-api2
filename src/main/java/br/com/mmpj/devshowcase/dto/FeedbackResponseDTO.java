package br.com.mmpj.devshowcase.dto;

import br.com.mmpj.devshowcase.model.Feedback;

public class FeedbackResponseDTO {
    private Long id;
    private String author;
    private String comment;
    private int rating;

    public FeedbackResponseDTO() {}

    public FeedbackResponseDTO(Feedback feedback) {
        this.id = feedback.getId();
        this.author = feedback.getAuthor();
        this.comment = feedback.getComment();
        this.rating = feedback.getRating();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}
