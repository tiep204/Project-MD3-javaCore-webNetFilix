package ra.bussiness.impl;

import ra.bussiness.design.IEpisode;
import ra.bussiness.entity.Catalog;
import ra.bussiness.entity.Episode;
import ra.bussiness.entity.Film;
import ra.config.Constanst;
import ra.config.Validation;
import ra.data.FileImpl;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EpisodeImpl implements IEpisode<Episode, Integer> {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    static FilmImpl film = new FilmImpl();

    @Override
    public boolean create(Episode episode) {
        List<Episode> list = readFromFile();
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(episode);
        return writeToFile(list);
    }

    @Override
    public boolean update(Episode episode) {
        List<Episode> episodeList = readFromFile();
        boolean found = false;
        for (int i = 0; i < episodeList.size(); i++) {
            if (episodeList.get(i).getEpisodeId() == episode.getEpisodeId()) {
                episodeList.set(i, episode);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("không tìm thấy tâp nao có trong danh sách. ");
            return false;
        }
        return writeToFile(episodeList);
    }

    @Override
    public boolean delete(Integer id) {
        List<Episode> episodeList = readFromFile();
        boolean check = false;
        for (Episode e : episodeList) {
            if (e.getEpisodeId() == id) {
                if (e.isStatus()) {
                    e.setStatus(false);
                } else {
                    e.setStatus(true);
                }
                check = true;
            }
        }
        boolean result = writeToFile(episodeList);
        return result && check;
    }

    @Override
    public boolean writeToFile(List<Episode> list) {
        FileImpl<Episode> episodeEpisode = new FileImpl<>();
        return episodeEpisode.writeDataToFile(list, Constanst.EPISODE_URL_FILE);
    }

    @Override
    public List<Episode> readFromFile() {
        FileImpl<Episode> filmFile = new FileImpl<>();
        return filmFile.readDataFromFile(Constanst.EPISODE_URL_FILE);
    }

    public Episode inputData(Scanner sc) {
        List<Episode> episodeList = readFromFile();
        if (episodeList == null) {
            episodeList = new ArrayList<>();
        }
        Episode episode = new Episode();
        List<Film> filmList = film.readFromFile();
        episode.setEpisodeId(episodeList.size() + 1);
        System.out.println(ANSI_CYAN + "      -------------------------------------------------------------------" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "       ******************Danh sách phim*******************************" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "      --------------------------------------------------------------------" + ANSI_RESET);
        System.out.printf(ANSI_YELLOW + "      %-10s %-25s %-20s\n", "ID", "Tên phim", "Năm phát hành" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "      --------------------------------------------------------------------" + ANSI_RESET);
        for (Film f : filmList) {
            if (f.isFilmType()) {
/*
                System.out.printf("%-10s %-25s %-20s %-20s\n", f.getFilmId(), f.getFilmName(), f.getFilmTitle(), (f.isFilmType() ? "Phim bộ" : "Phim lẻ"));
*/

                System.out.printf("      %-10d %-25s %-25s\n",
                        f.getFilmId(), f.getFilmName(), (f.isFilmStatus() ? "Đang phát hành" : "Ngừng phát hành"));
            }
        }
        System.out.println(ANSI_CYAN +"---------------------------------------------------------------------------"+ ANSI_RESET);
        boolean filmExists = false;
        int filmId;
        do {
            System.out.println("Mời bạn nhập ID của phim");
            filmId = Validation.getInteger();
            for (Film f : filmList) {
                if (f.getFilmId() == filmId && f.isFilmType()) {
                    filmExists = true;
                    break;
                }
            }
            if (!filmExists) {
                System.err.println("ID phim không hợp lệ hoặc không phải phim bộ. Vui lòng nhập lại.");
            }
        } while (!filmExists);
        episode.setFilmId(film.findByid(filmId));
        System.out.println("Mời bạn nhập tên tập phim");
        episode.setEpisodeName(Validation.checkEpisodeName(filmId));
        System.out.println("Mời bạn nhập mô tả của tập phim");
        episode.setDecription(Validation.getString());
        System.out.println("Mời bạn nhập thời lượng của tập phim");
        String duration = Validation.getString();
        Duration duration1 = Validation.parseDuration(duration);
        episode.setDuration(duration1);
        episode.setReleaseDate(new Date());
        System.out.println("Mời bạn nhập link tập phim");
        episode.setUrl(Validation.getString());
        episode.setStatus(true);
        return episode;
    }

    public List<Episode> findByEpisodeName(String name) {
        List<Episode> list = readFromFile();
        List<Episode> result = new ArrayList<>();
        for (Episode episode : list) {
            if (episode.getFilmId().getFilmName().contains(name)) {
                result.add(episode);
            }
        }
        return result;
    }

    @Override
    public void displayData() {
        List<Episode> episodeList = readFromFile();
        if (episodeList == null || episodeList.isEmpty()) {
            System.out.println("Không có dữ liệu tập phim.");
        } else {
            System.out.println(ANSI_CYAN +"                     -----------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                                 *****************************Danh sách tập phim***********************************"+ ANSI_RESET);
            System.out.println(ANSI_CYAN +"                     -----------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.printf(ANSI_YELLOW +"                        %-10s %-25s %-25s %-25s %-30s %-20s \n", "ID", "Tên tập phim", "Tên phim", "Thời lượng", "Ngày phát hành", "Trạng thái"+ ANSI_RESET);
            System.out.println(ANSI_CYAN +"                     -----------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            for (Episode episode : episodeList) {
                Duration duration = episode.getDuration();
                String durationStr;
                if (duration != null) {
                    long hours = duration.toHours();
                    long minutes = duration.toMinutes() % 60;
                    long seconds = duration.getSeconds() % 60;
                    durationStr = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                } else {
                    durationStr = "";
                }
                String pattern = "dd-M-yyyy hh:mm:ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                System.out.printf("                        %-10s %-25s %-25s %-25s %-30s %-20s%n", episode.getEpisodeId(), episode.getEpisodeName(), episode.getFilmId().getFilmName(),
                        durationStr, simpleDateFormat.format(episode.getReleaseDate()),
                        (episode.isStatus() ? "Đang phát" : "Ngừng phát"));
            }
            System.out.println(ANSI_CYAN +"                     -----------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
        }
    }

    public void displayDataDetail(int id) {
        List<Episode> episodeList = readFromFile();
        if (episodeList == null || episodeList.isEmpty()) {
            System.out.println("Không có dữ liệu tập phim.");
        } else {
            System.out.println("*****************************Danh sách tập phim***********************************");
            System.out.printf("%-25s %-25s %-15s %-20s %-15s%n",
                    "Tên tập phim", "Tên phim", "Thời lượng", "Ngày phát hành", "Trạng thái");
            for (Episode episode : episodeList) {
                if (episode.getFilmId().getFilmId() == id && episode.isStatus()) {
                    Duration duration = episode.getDuration();
                    String durationStr;
                    if (duration != null) {
                        long hours = duration.toHours();
                        long minutes = duration.toMinutes() % 60;
                        long seconds = duration.getSeconds() % 60;
                        durationStr = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                    } else {
                        durationStr = "";
                    }
                    String pattern = "dd-M-yyyy hh:mm:ss";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                    System.out.printf("%-25s %-25s %-15s %-20s %-15s%n", episode.getEpisodeName(), episode.getFilmId().getFilmName(),
                            durationStr, simpleDateFormat.format(episode.getReleaseDate()),
                            (episode.isStatus() ? "Đang phát" : "Ngừng phát"));
                }
            }
        }
    }
}