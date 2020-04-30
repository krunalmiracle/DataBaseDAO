package edu.upc.eetac.dsa.orm;

import edu.upc.eetac.dsa.RandomUtils;
import edu.upc.eetac.dsa.orm.util.ObjectHelper;
import edu.upc.eetac.dsa.orm.util.QueryHelper;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
            //Only Primitive Types Int String Double
            for (String field: ObjectHelper.getStrFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }
            pstm.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    public void saveList(Object entity){
        //For a Player which contains listItems, this will save all the items in the table items
        try {
            Object objList = null;
            //listObjects Relational Mapping to ObjectName Table
            for (Field field: ObjectHelper.getListFields(entity)) {
                //Create Query for the List Field Primitive Type
                //Gets the Name of the Type inside List
                //ParameterizedType fieldListGenericType = (ParameterizedType) field.getGenericType();
                //Class<?> theClazz = (Class<?>) fieldListGenericType.getActualTypeArguments()[0];
                //System.out.println(theClazz); // class java.lang.Object
                //Get the Object from the List of Objects
                //obj = theClazz.newInstance();
                objList = ObjectHelper.getter(entity,field.getName());
                //Class<?> cls = Class.forName("String");
                for (Object o :(List) objList) {
                    // Save the Object in Database in the Corresponding Table
                    save(o);
                }
            }
            //EXECUTE STATEMENT
            //REPEAT ABOVE STATEMENT TILL SIZE OF LIST OBJECTSs
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    //Completed getObject(Player..) with list as null, use getList for that!
    public Object get(Class theClass, String ID) {
        String selectQuery = QueryHelper.createQuerySELECT(theClass);
        Object obj = null; PreparedStatement pstm = null;
        //Instantiating a object of type class for the getters
        try {
            obj = theClass.newInstance();
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, ID);
            ResultSet resultSet =  pstm.executeQuery();
            //INVOKE SETTER FOR EACH CORRESPONDING PROPERTY OF THE TABLE TO MAP WITH OBJECT
            while (resultSet.next()){
                Field[] fields = theClass.getDeclaredFields();
                //SQL WILL NEVER RETURN LIST AS A RESULT
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
        return obj;
    }
    // Given Class (Item,Material) with parentID returns list<E>
    public List<Class> getList(Class theClass,String parentID){
        String selectQuery = QueryHelper.createParentIDQuerySELECT(theClass);
         PreparedStatement pstm = null;
        //Instantiating a object of type class for the getters
        List<Class> objList = new LinkedList<>();
        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, parentID);
            ResultSet resultSet = pstm.executeQuery();
            while(resultSet.next()) {
                Object obj = null; obj = theClass.newInstance();
                Field[] fields = ObjectHelper.getFields(obj);

                resultSet.getString(1);
                for(int i = 0; i < fields.length; i ++) {
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    String name = resultSetMetaData.getColumnName(i + 2);
                    if(name!="parentID")
                        obj =  ObjectHelper.setter(obj, name, resultSet.getObject(i + 2));
                }
                //We have filled all of the fields inside the Object of type <E>
                objList.add((Class) obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return objList;
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
    public void delete(Object o) throws Exception {
        String delete = QueryHelper.createQueryDELETE(o);
        PreparedStatement pstm = null;
        try {
            pstm=conn.prepareStatement(delete);
            for(String field: ObjectHelper.getStrFields(o)){
                if(field.equals("getID")) {
                    pstm.setObject(1, ObjectHelper.getter(o, field));
                }
                pstm.executeQuery();
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }
    // TODO FINISH THE GET ALL OF THE DATA FROM DB GIVEN THE CLASS(model)
    public List<Object> findAll(Class theclass) throws SQLException {
        String findall = QueryHelper.createQuerySELECT(theclass);
        PreparedStatement pstm = null;
        try {
        pstm = conn.prepareStatement(findall);
        List<Object> tableNames = new ArrayList<>();
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            tableNames.add(rs.getObject(1));
        }
        return tableNames;
        } catch (SQLException e) {
            e.printStackTrace();
        }


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
