package ch.puzzle.springboot.workshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class MovieQuote {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String quote;

    @Column(nullable = false)
    private String character;

    @Column(nullable = false)
    private String actor;

    @Column(nullable = false)
    private String movie;

    @Column(nullable = false)
    private Date year;

    public MovieQuote() {

    }

    public MovieQuote(String quote, String character, String actor, String movie, Date year) {
        this.quote = quote;
        this.character = character;
        this.actor = actor;
        this.movie = movie;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public String getQuote() {
        return quote;
    }

    public String getCharacter() {
        return character;
    }

    public String getActor() {
        return actor;
    }

    public String getMovie() {
        return movie;
    }

    public Date getYear() {
        return year;
    }

}
