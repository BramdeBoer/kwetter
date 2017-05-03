package dto;

/**
 * Created by bramd on 3-5-2017.
 */
import model.Tweet;

import java.util.Date;

public class TweetDTO {
    private long id;
    private String content;
    private Date date;
    private String createdBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public TweetDTO(Tweet tweet) {
        this.id = tweet.getId();
        this.content = tweet.getContent();
        this.date = tweet.getDate();
        this.createdBy = tweet.getCreatedBy().getUsername();
    }
}
