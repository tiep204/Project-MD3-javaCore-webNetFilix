package ra.bussiness.impl;

import ra.bussiness.design.ILike;
import ra.bussiness.entity.Film;
import ra.bussiness.entity.Like;
import ra.bussiness.entity.User;
import ra.config.Constanst;
import ra.config.Validation;
import ra.data.FileImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LikeImpl implements ILike<Like, Integer> {
    private static LikeImpl like = new LikeImpl();
    private static UserImpl userImpl = new UserImpl();
    private static int likeIdCounter = 1; // Biến đếm để tạo ID cho Like

    @Override
    public boolean create(Like like) {
        List<Like> likeList = readFromFile();
        if (likeList == null) {
            likeList = new ArrayList<>();
        }
        likeList.add(like);
        return writeToFile(likeList);
    }

    @Override
    public boolean update(Like like) {
        List<Like> likeList = readFromFile();
        boolean found = false;
        for (int i = 0; i < likeList.size(); i++) {
            if (likeList.get(i).getLikeId() == like.getLikeId()) {
                likeList.set(i, like);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy ID của Like.");
        }
        return writeToFile(likeList);
    }

    @Override
    public boolean delete(Integer id) {
        List<Like> likeList = readFromFile();
        boolean found = false;
        for (Like like : likeList) {
            if (like.getLikeId() == id) {
                likeList.remove(like);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy ID của Like.");
        }
        return writeToFile(likeList);
    }

    @Override
    public boolean writeToFile(List<Like> list) {
        FileImpl<Like> likeFile = new FileImpl<>();
        return likeFile.writeDataToFile(list, Constanst.LIKE_URL_FILE);
    }

    @Override
    public List<Like> readFromFile() {
        FileImpl<Like> likeFile = new FileImpl<>();
        return likeFile.readDataFromFile(Constanst.LIKE_URL_FILE);
    }


    @Override
    public Like inputData(Scanner sc) {
        return null;
    }

    public int getNewId() {
        List<Like> likeList = readFromFile();
        int max = 0;
        for (Like u : likeList) {
            if (u.getLikeId() > max) {
                max = u.getLikeId();
            }
        }
        return max + 1;
    }

    @Override
    public void displayData() {
        List<Like> likeList = readFromFile();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("**********************************Danh sách bạn đã like*************************************************");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.printf("%-35s %-35s %-25s\n", "Tên phim", "Tên người dùng", "ngày giờ like");
        for (Like like : likeList) {
            if (userImpl.userLogin().getUserId() == like.getUser().getUserId()) {
                if (like.isLikeStatus()) {
                    String formattedDate = dateFormat.format(like.getLikeDate());
                    System.out.printf("%-35s %-35s %-25s %10b \n", like.getFilm().getFilmName(), like.getUser().getUsername(), formattedDate, like.isLikeStatus(),like.getLikeId());
                }
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }

    public boolean toggleLikeFilm(User user, Film film) {
        List<Like> likeList = readFromFile();
        boolean liked = false;

        for (Like like : likeList) {
            if (like.getUser().getUserId()==user.getUserId() && like.getFilm().getFilmId() == film.getFilmId()) {
                likeList.remove(like);
                liked = true;
                break;
            }
        }
        if (!liked) {
            Like newLike = new Like();
            newLike.setLikeId(getNewId());
            newLike.setUser(user);
            newLike.setFilm(film);
            newLike.setLikeStatus(true);
            newLike.setLikeDate(new Date());
            likeList.add(newLike);
            liked = false;
        }

        boolean result = writeToFile(likeList);
        if (result) {
            return liked;
        } else {
            return !liked;
        }
    }
}