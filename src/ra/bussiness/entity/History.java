package ra.bussiness.entity;

import java.io.Serializable;
import java.time.Duration;
import java.util.Date;

public class History implements Serializable {
    private int historyId;
    private User userId;
    private Film filmId;
    private Episode episodeId;
    private Duration watchTime;
    private Date dateTime;

    private long runningTime;

    public History(History history) {
        this.historyId = history.getHistoryId();
        this.userId = history.userId;
        this.filmId = history.filmId;
        this.episodeId = history.episodeId;
        this.watchTime = history.getWatchTime();
        this.dateTime = history.dateTime;
        this.runningTime = history.getRunningTime();
    }

    public long getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(long runningTime) {
        this.runningTime = runningTime;
    }

    public History() {
    }

    public History(int historyId, User userId, Film filmId, Episode episodeId, Duration watchTime, Date dateTime) {
        this.historyId = historyId;
        this.userId = userId;
        this.filmId = filmId;
        this.episodeId = episodeId;
        this.watchTime = watchTime;
        this.dateTime = dateTime;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Film getFilmId() {
        return filmId;
    }

    public void setFilmId(Film filmId) {
        this.filmId = filmId;
    }

    public Episode getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Episode episodeId) {
        this.episodeId = episodeId;
    }

    public Duration getWatchTime() {
        return watchTime;
    }

    public void setWatchTime(Duration watchTime) {
        this.watchTime = watchTime;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}