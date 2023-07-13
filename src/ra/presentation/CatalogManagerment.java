package ra.presentation;

import ra.bussiness.entity.Catalog;
import ra.bussiness.impl.CatalogImpl;
import ra.config.Validation;

import java.util.List;
import java.util.Scanner;

public class CatalogManagerment {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static CatalogImpl catalogImp = new CatalogImpl();
    public static List<Catalog> catalogList = catalogImp.readFromFile();
    public static void catalogManagerment(Scanner sc) {
        boolean check = true;
        do {
            System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                                            *------------------Category Managerment------------------*"+ ANSI_RESET);
            System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
            System.out.println(             "                                                            *                   1. Thêm danh mục                     *");
            System.out.println(             "                                                            *                   2. Sửa danh mục                      *");
            System.out.println(             "                                                            *                   3. Xóa danh mục                      *");
            System.out.println(             "                                                            *                   4. Hiển thị danh sách danh mục       *");
            System.out.println(             "                                                            *                   5. Tìm kiếm danh mục theo tên        *");
            System.out.println(             "                                                            *                   6. Thoát                             *");
            System.out.println(ANSI_CYAN +  "                                                            ----------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_CYAN +  "                                                            *                Sự lựa chọn của bạn:                     "+ ANSI_RESET);
            System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println(             "                                                            *------------------Category Managerment------------------*");
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println(ANSI_YELLOW +"                                                            *                   1. Thêm danh mục                     *"+ ANSI_RESET);
                    System.out.println(             "                                                            *                   2. Sửa danh mục                      *");
                    System.out.println(             "                                                            *                   3. Xóa danh mục                      *");
                    System.out.println(             "                                                            *                   4. Hiển thị danh sách danh mục       *");
                    System.out.println(             "                                                            *                   5. Tìm kiếm danh mục theo tên        *");
                    System.out.println(             "                                                            *                   6. Thoát                             *");
                    System.out.println(ANSI_CYAN +  "                                                            ----------------------------------------------------------"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +  "                                                            *                Sự lựa chọn của bạn:                     "+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    create(sc);
                    break;
                case 2:
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println(             "                                                            *------------------Category Managerment------------------*");
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println(             "                                                            *                   1. Thêm danh mục                     *");
                    System.out.println(ANSI_YELLOW +"                                                            *                   2. Sửa danh mục                      *"+ ANSI_RESET);
                    System.out.println(             "                                                            *                   3. Xóa danh mục                      *");
                    System.out.println(             "                                                            *                   4. Hiển thị danh sách danh mục       *");
                    System.out.println(             "                                                            *                   5. Tìm kiếm danh mục theo tên        *");
                    System.out.println(             "                                                            *                   6. Thoát                             *");
                    System.out.println(ANSI_CYAN +  "                                                            ----------------------------------------------------------"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +  "                                                            *                Sự lựa chọn của bạn:                     "+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    findAll();
                    update();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println(             "                                                            *------------------Category Managerment------------------*");
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println(             "                                                            *                   1. Thêm danh mục                     *");
                    System.out.println(             "                                                            *                   2. Sửa danh mục                      *");
                    System.out.println(ANSI_YELLOW +"                                                            *                   3. Xóa danh mục                      *"+ ANSI_RESET);
                    System.out.println(             "                                                            *                   4. Hiển thị danh sách danh mục       *");
                    System.out.println(             "                                                            *                   5. Tìm kiếm danh mục theo tên        *");
                    System.out.println(             "                                                            *                   6. Thoát                             *");
                    System.out.println(ANSI_CYAN +  "                                                            ----------------------------------------------------------"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +  "                                                            *                Sự lựa chọn của bạn:                     "+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    findAll();
                    delete();
                    break;
                case 4:
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println(             "                                                            *------------------Category Managerment------------------*");
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println(             "                                                            *                   1. Thêm danh mục                     *");
                    System.out.println(             "                                                            *                   2. Sửa danh mục                      *");
                    System.out.println(             "                                                            *                   3. Xóa danh mục                      *");
                    System.out.println(ANSI_YELLOW +"                                                            *                   4. Hiển thị danh sách danh mục       *"+ ANSI_RESET);
                    System.out.println(             "                                                            *                   5. Tìm kiếm danh mục theo tên        *");
                    System.out.println(             "                                                            *                   6. Thoát                             *");
                    System.out.println(ANSI_CYAN +  "                                                            ----------------------------------------------------------"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +  "                                                            *                Sự lựa chọn của bạn:                     "+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    findAll();
                    break;
                case 5:
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println(             "                                                            *------------------Category Managerment------------------*");
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println(             "                                                            *                   1. Thêm danh mục                     *");
                    System.out.println(             "                                                            *                   2. Sửa danh mục                      *");
                    System.out.println(             "                                                            *                   3. Xóa danh mục                      *");
                    System.out.println(             "                                                            *                   4. Hiển thị danh sách danh mục       *");
                    System.out.println(ANSI_YELLOW +"                                                            *                   5. Tìm kiếm danh mục theo tên        *"+ ANSI_RESET);
                    System.out.println(             "                                                            *                   6. Thoát                             *");
                    System.out.println(ANSI_CYAN +  "                                                            ----------------------------------------------------------"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +  "                                                            *                Sự lựa chọn của bạn:                     "+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    searchByName();
                    break;
                case 6:
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println(             "                                                            *------------------Category Managerment------------------*");
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println(             "                                                            *                   1. Thêm danh mục                     *");
                    System.out.println(             "                                                            *                   2. Sửa danh mục                      *");
                    System.out.println(             "                                                            *                   3. Xóa danh mục                      *");
                    System.out.println(             "                                                            *                   4. Hiển thị danh sách danh mục       *");
                    System.out.println(             "                                                            *                   5. Tìm kiếm danh mục theo tên        *");
                    System.out.println(ANSI_YELLOW +"                                                            *                   6. Thoát                             *"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +  "                                                            ----------------------------------------------------------"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +  "                                                            *                Sự lựa chọn của bạn:                     "+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +  "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println("");
                    check = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (check);
    }

    public static void create(Scanner sc) {
        System.out.print("Mời bạn nhập số lượng danh mục/phim bạn cần thêm mới: ");
        int num = Validation.getInteger();
        if (num > 0) {
            for (int i = 0; i < num; i++) {
                Catalog catalog = new Catalog();
                System.out.println("Thông tin danh mục/phim thứ " + (i + 1) + ":");
                catalog = catalogImp.inputData(sc);
                catalog.setCatalogStatus(true);
                catalogImp.create(catalog);
            }
            System.out.println("Bạn đã thêm thành công " + num + " danh mục/phim.");
        } else {
            System.out.println("Thêm danh mục/phim thất bại.");
        }
    }



    public static void update() {
        List<Catalog> catalogList = catalogImp.readFromFile();
        System.out.println("Mời bạn nhập id danh mục muốn cập nhật: ");
        boolean check = false;
        int id = Validation.getInteger();
        for (Catalog cat : catalogList) {
            if (cat.getCatalogId() == id) {
                System.out.println("Mời bạn nhập tên danh mục ");
                String str = Validation.getString();
                cat.setCatalogName(str);
                System.out.println("Mời bạn nhập trạng thái của danh mục");
                System.out.println("1.Hoạt động");
                System.out.println("2.Không hoạt động");
                System.out.println("sự lựa chọn của bạn ");
                int choice = Validation.getInteger();
                switch (choice) {
                    case 1:
                        cat.setCatalogStatus(true);
                        break;
                    case 2:
                        cat.setCatalogStatus(false);
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-2");
                }
                check = catalogImp.update(cat);
                break;
            }
        }
        if (check) {
            System.out.println("Bạn đã cập nhật thành công");
        } else {
            System.err.println("Cập nhật thất bại");
        }
    }

    public static void delete() {
        System.out.println("Mời bạn nhập id danh mục bạn muốn xóa:");
        int id = Validation.getInteger();
        boolean check = false;
        for (Catalog cat : catalogList) {
            if (cat.getCatalogId() == id) {
                cat.setCatalogStatus(false);
                check = catalogImp.update(cat);
                break;
            }
        }
        if (check) {
            System.out.println("xóa thành công");
        } else {
            System.out.println("xóa không thành công");
        }
    }

    public static void findAll() {
        System.out.println(ANSI_CYAN +  "                                                ----------------------------------------------------------------------------------"+ ANSI_RESET);
        System.out.println(ANSI_YELLOW +"                                                ******************************Danh Sách Danh Mục**********************************"+ ANSI_RESET);
        System.out.println(ANSI_CYAN + "                                                ----------------------------------------------------------------------------------"+ ANSI_RESET);
        System.out.printf(              "                                                 %-25s %-40s %-35s \n", "Id danh mục", "Tên danh mục", "Trạng thái");
        System.out.println( ANSI_CYAN + "                                                ----------------------------------------------------------------------------------"+ ANSI_RESET);
        catalogImp.displayData();
        System.out.println( ANSI_CYAN +  "                                                ----------------------------------------------------------------------------------"+ ANSI_RESET);
    }

    public static void searchByName() {
        System.out.print("Mời bạn nhập tên danh mục muốn tìm kiếm: ");
        String name = Validation.getString();
        List<Catalog> catalogList1 = catalogImp.findByCatalogName(name);
        if (catalogList1 == null) {
            System.out.println("không có danh mục mày");
        } else {
            System.out.println(ANSI_CYAN +  "                                                ----------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                                ******************************Danh Sách Danh Mục**********************************"+ ANSI_RESET);
            System.out.println(ANSI_CYAN + "                                                ----------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.printf(              "                                                 %-25s %-40s %-35s \n", "Id danh mục", "Tên danh mục", "Trạng thái");
            System.out.println( ANSI_CYAN + "                                                ----------------------------------------------------------------------------------"+ ANSI_RESET);
            for (Catalog cat : catalogList1) {
                System.out.printf("                                                %-25d %-40s %-35s \n", cat.getCatalogId(), cat.getCatalogName(), (cat.isCatalogStatus() ? "Hoạt Động" : "không hoạt động"));
            }
            System.out.println( ANSI_CYAN +  "                                                ----------------------------------------------------------------------------------"+ ANSI_RESET);
        }
    }
}