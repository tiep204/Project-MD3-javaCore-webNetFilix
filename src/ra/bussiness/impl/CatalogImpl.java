package ra.bussiness.impl;

import ra.bussiness.design.ICatalog;
import ra.bussiness.design.ICrud;
import ra.bussiness.entity.Catalog;
import ra.config.Constanst;
import ra.config.Validation;
import ra.data.FileImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogImpl implements ICatalog<Catalog, Integer> {
    @Override
    public boolean create(Catalog catalog) {
        List<Catalog> listCatalog = readFromFile();
        if (listCatalog == null) {
            listCatalog = new ArrayList<>();
        }
        listCatalog.add(catalog);
        return writeToFile(listCatalog);
    }

    @Override
    public boolean update(Catalog catalog) {
        List<Catalog> catalogList = readFromFile();
        boolean returnData = false;
        for (int i = 0; i < catalogList.size(); i++) {
            if (catalogList.get(i).getCatalogId() == catalog.getCatalogId()) {
                catalogList.set(i, catalog);
                returnData = true;
                break;
            }
        }
        boolean result = writeToFile(catalogList);
        if (result && returnData) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        List<Catalog> catalogList = readFromFile();
        boolean returnData = false;
        for (int i = 0; i < catalogList.size(); i++) {
            if (catalogList.get(i).getCatalogId() == id) {
                catalogList.remove(i);
                returnData = true;
                break;
            }
        }
        boolean result = writeToFile(catalogList);
        if (result && returnData) {
            return true;
        }
        return false;
    }

    @Override
    public boolean writeToFile(List<Catalog> list) {
        FileImpl<Catalog> file = new FileImpl<>();
        return file.writeDataToFile(list, Constanst.CATALOG_URL_FILE);
    }

    @Override
    public List<Catalog> readFromFile() {
        FileImpl<Catalog> catalogFile = new FileImpl<>();
        return catalogFile.readDataFromFile(Constanst.CATALOG_URL_FILE);
    }

    @Override
    public List<Catalog> findByCatalogName(String name) {
        List<Catalog> list = readFromFile();
        List<Catalog> list1 = new ArrayList<>();
        for (Catalog cat : list) {
            if (cat.getCatalogName().contains(name)) {
                list1.add(cat);
            }
        }
        return list1;
    }

    @Override
    public Catalog inputData(Scanner sc) {
        List<Catalog> catalogList = readFromFile();
        if (catalogList == null) {
            catalogList = new ArrayList<>();
        }
        Catalog cat = new Catalog();
        cat.setCatalogId(catalogList.size() + 1);
        System.out.print("Mời bạn nhập tên danh mục: ");
        cat.setCatalogName(Validation.getString());
        return cat;
    }

    @Override
    public void displayData() {
        List<Catalog> catalogList = readFromFile();
        for (Catalog cat : catalogList) {
            System.out.printf("                                                 %-25d %-40s %-35s \n", cat.getCatalogId(), cat.getCatalogName(), (cat.isCatalogStatus() ? "Hoạt Động" : "không hoạt động"));
        }
    }
}