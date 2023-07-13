package ra.bussiness.entity;

import java.io.Serializable;
import java.time.Duration;
import java.util.Date;

public class Episode implements Serializable {
    private int episodeId;
    private String episodeName;
    private String decription;
    private Duration duration;
    private Date releaseDate;
    private String url;
    private boolean status;
    private Film filmId;

    public Episode() {
    }

    public Episode(int episodeId, String episodeName, String decription, Duration duration, Date releaseDate, String url, boolean status, Film filmId) {
        this.episodeId = episodeId;
        this.episodeName = episodeName;
        this.decription = decription;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.url = url;
        this.status = status;
        this.filmId = filmId;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Film getFilmId() {
        return filmId;
    }

    public void setFilmId(Film filmId) {
        this.filmId = filmId;
    }
}