package edu.upc.eetac.dsa.orm;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface Session<E> {
    String save(Object entity);
    void close();
    Object get(Class theClass, String ID);
    List<Class> getList(Class theClass,String parentID);
    void saveList(Object entity);
    void update(Object object);
    void delete(Object o) throws Exception;
    List<Object> findAll(Class theClass) throws SQLException;
    List<Object> findAll(Class theClass, HashMap params);
    List<Object> query(String query, Class theClass, HashMap params);
}
