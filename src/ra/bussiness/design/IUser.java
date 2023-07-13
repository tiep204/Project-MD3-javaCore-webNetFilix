package ra.bussiness.design;

import ra.bussiness.entity.User;

import java.util.List;

public interface IUser<T,E> extends ICrud<T,E>{
    T checkLogin(String name,String pass);
    List<T> findbyUserName (String name);
}