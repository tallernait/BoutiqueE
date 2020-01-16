package tn.co.DAO;

import java.util.List;

public interface IDAO<T> {
    public void create(Object o);
    public List<T> readAll();
    public void delete(int id);
}
