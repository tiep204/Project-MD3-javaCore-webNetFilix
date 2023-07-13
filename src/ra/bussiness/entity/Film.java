package ra.bussiness.entity;

import java.io.Serializable;
import java.time.Duration;
import java.util.List;

public class Film implements Serializable {
    private int filmId;
    private String filmName;
    private String filmTitle;
    private String decription;
    private boolean filmType;
    private Duration duration;
    private String filmNation;
    private String filmLanguage;
    private boolean filmBrowse;
    private int filmYearRelease;
    private String filmDirector;
    private List<Catalog> catalogList;
    private List<String> performer;
    private boolean filmStatus;
    private int views;

    public Film() {
    }

    public Film(int filmId, String filmName, String filmTitle, String decription, boolean filmType, Duration duration, String filmNation, String filmLanguage, boolean filmBrowse, int filmYearRelease, String filmDirector, List<Catalog> catalogList, List<String> performer, boolean filmStatus, int views) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.filmTitle = filmTitle;
        this.decription = decription;
        this.filmType = filmType;
        this.duration = duration;
        this.filmNation = filmNation;
        this.filmLanguage = filmLanguage;
        this.filmBrowse = filmBrowse;
        this.filmYearRelease = filmYearRelease;
        this.filmDirector = filmDirector;
        this.catalogList = catalogList;
        this.performer = performer;
        this.filmStatus = filmStatus;
        this.views = views;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public boolean isFilmType() {
        return filmType;
    }

    public void setFilmType(boolean filmType) {
        this.filmType = filmType;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getFilmNation() {
        return filmNation;
    }

    public void setFilmNation(String filmNation) {
        this.filmNation = filmNation;
    }

    public String getFilmLanguage() {
        return filmLanguage;
    }

    public void setFilmLanguage(String filmLanguage) {
        this.filmLanguage = filmLanguage;
    }

    public boolean isFilmBrowse() {
        return filmBrowse;
    }

    public void setFilmBrowse(boolean filmBrowse) {
        this.filmBrowse = filmBrowse;
    }

    public int getFilmYearRelease() {
        return filmYearRelease;
    }

    public void setFilmYearRelease(int filmYearRelease) {
        this.filmYearRelease = filmYearRelease;
    }

    public String getFilmDirector() {
        return filmDirector;
    }

    public void setFilmDirector(String filmDirector) {
        this.filmDirector = filmDirector;
    }

    public List<Catalog> getCatalogList() {
        return catalogList;
    }

    public void setCatalogList(List<Catalog> catalogList) {
        this.catalogList = catalogList;
    }

    public List<String> getPerformer() {
        return performer;
    }

    public void setPerformer(List<String> performer) {
        this.performer = performer;
    }

    public boolean isFilmStatus() {
        return filmStatus;
    }

    public void setFilmStatus(boolean filmStatus) {
        this.filmStatus = filmStatus;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}