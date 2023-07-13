package ra.bussiness.entity;

import java.io.Serializable;
import java.util.Date;

public class Like implements Serializable {
    private int likeId;
    private User user;
    private Film film;
    private Episode episode;
    private boolean likeStatus;
    private Date likeDate;

    public Like() {
    }

    public Like(int likeId, User user, Film film, Episode episode, boolean likeStatus, Date likeDate) {
        this.likeId = likeId;
        this.user = user;
        this.film = film;
        this.episode = episode;
        this.likeStatus = likeStatus;
        this.likeDate = likeDate;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public boolean isLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(boolean likeStatus) {
        this.likeStatus = likeStatus;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }
}