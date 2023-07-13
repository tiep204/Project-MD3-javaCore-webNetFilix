package ra.bussiness.design;

import java.util.List;

public interface ICatalog<T,E> extends ICrud<T,E> {
    List<T> findByCatalogName (String name);
}