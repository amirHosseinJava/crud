package springdemo.service;

import java.io.Serializable;
import java.util.List;

public interface GeneralService <T,PK extends Serializable>{
    public List<T> getListServ ();
    public void saveServ (T entity);
   public T getServ(PK id);
   public void deleteServ (T entity);
}
