package ra.bussiness.design;

import java.util.List;

public interface IFilm<T,E> extends ICrud<T,E>{
    List<T> findByFilmName (String name);
}