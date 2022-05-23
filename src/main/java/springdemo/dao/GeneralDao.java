package springdemo.dao;

import java.io.Serializable;
import java.util.List;

public interface GeneralDao <T,PK extends Serializable>{
    public List <T> getListDao();
    public void saveDao(T entity);
    public T getDao(Integer id);
    public void deleteDao(T entity);
}
