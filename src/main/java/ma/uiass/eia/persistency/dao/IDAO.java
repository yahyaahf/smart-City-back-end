package ma.uiass.eia.persistency.dao;

import java.util.List;

public interface IDAO<T> {

   void create(T object);
   void update (T object , long id);
   T getById(long id );
   void delete(T object);
   List<T>getAll();

}
