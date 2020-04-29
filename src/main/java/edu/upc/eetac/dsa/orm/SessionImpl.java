package edu.upc.eetac.dsa.orm;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import edu.upc.eetac.dsa.RandomUtils;
import edu.upc.eetac.dsa.orm.util.ObjectHelper;
import edu.upc.eetac.dsa.orm.util.QueryHelper;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.List;


public class SessionImpl implements Session {
    private final Connection conn;
    private static final int sizeID = 16;
    public SessionImpl(Connection conn) {
        this.conn = conn;
    }
    // TODO FINISHED!
    public void save(Object entity) {

        String insertQuery = QueryHelper.createQueryINSERT(entity);
        RandomUtils randomUtils = new RandomUtils();
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            pstm.setObject(1,randomUtils.generateId(sizeID) );
            int i = 2;

            for (String field: ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }

            pstm.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            close();
        }

    }
    // TODO FINISHED!
    public void close() {
        try {
            this.conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    // TODO FINISHED!
    public Object get(Class theClass, String ID) {

        String selectQuery = QueryHelper.createQuerySELECT(theClass);

        Object obj = null;PreparedStatement pstm = null;
        //Instantiating a object of type class for the getters
        try {
            obj = theClass.newInstance();
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, ID);
            ResultSet resultSet =  pstm.executeQuery();
            // TODO ADD TO OBJECT THE CORRESPONDING VALUES FROM THE RESULT SET
            //INVOKE SETTER FOR EACH CORRESPONDING PROPERTY OF THE TABLE TO MAP WITH OBJECT
            while (resultSet.next()){
                Field[] fields = theClass.getDeclaredFields();
                resultSet.getString(1);
                for(int i = 0; i < fields.length; i ++){
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    String name = resultSetMetaData.getColumnName(i+2);

                    ObjectHelper.setter(obj,name, resultSet.getObject(i+2));
                }
            }
        }catch (InstantiationException|SQLException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    // TODO FINISH THE MOFICATION OF THE OBJECT GIVEN THE UPDATED OBJECT
    public void update(Object object) {
        String updateQuery = QueryHelper.createQueryUPDATE(object);
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(updateQuery);
            pstm.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            close();
        }

    }
    // TODO FINISH THE DELETE OBJECT FROM DB GIVEN THE OBJECT
    public void delete(Class c, String ID) {
        String delete = QueryHelper.createQueryDELETE(c);
        PreparedStatement pstm = null;
        try {
            Object obj = c.newInstance();
            pstm=conn.prepareStatement(delete);
            pstm.setObject(1, ID);
            ResultSet res = pstm.executeQuery();
        } catch (InstantiationException|SQLException|IllegalAccessException e) {
            e.printStackTrace();
        }

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
