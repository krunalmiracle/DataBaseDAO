package edu.upc.eetac.dsa.orm;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import edu.upc.eetac.dsa.orm.util.ObjectHelper;
import edu.upc.eetac.dsa.orm.util.QueryHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


public class SessionImpl implements Session {
    private final Connection conn;

    public SessionImpl(Connection conn) {
        this.conn = conn;
    }

    public void save(Object entity) {

        String insertQuery = QueryHelper.createQueryINSERT(entity);

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            pstm.setObject(1, 0);
            int i = 2;

            for (String field: ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }

            pstm.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // FINISHED
    public void close() {
        try {
            this.conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    // TODO FINISH THE GET OBJECT WITH ID FROM DB
    public Object get(Class theClass, int ID) {
        return null;
    }
    // TODO FINISH THE MOFICATION OF THE OBJECT GIVEN THE UPDATED OBJECT
    public void update(Object object) {

    }
    // TODO FINISH THE DELETE OBJECT FROM DB GIVEN THE OBJECT
    public void delete(Object object) {

    }
    // TODO FINISH THE GET ALL OF THE DATA FROM DB GIVEN THE CLASS(model)
    public List<Object> findAll(Class theClass) {
        return null;
    }
    // TODO FINISH THE GET ALL OF THE DATA FROM DB GIVEN THE CLASS(model) & THE PARAMETERS WHICH MATCH THE HASH
    public List<Object> findAll(Class theClass, HashMap params) {
        return null;
    }
    // TODO FINISH THE SUBJECTIVE QUEURY WHICH WILL BE PASS THROUGH AS A SENTENCE(USE STATEMENTS)
    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }
}
