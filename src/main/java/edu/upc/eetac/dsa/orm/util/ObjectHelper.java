package edu.upc.eetac.dsa.orm.util;


import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObjectHelper {
    //Returns Normal Primitive Fields
    public static String[] getFields(Object entity) {

        Class theClass = entity.getClass();

        Field[] fields = theClass.getDeclaredFields();
        ArrayList<String> sFields = new ArrayList<String>();
        int i=0;

        for (Field f: fields) {
            if(!f.getName().contains("list"))
               sFields.add(f.getName()) ;
        }
        String[] sFieldsArr = new String[sFields.size()];
        sFieldsArr = sFields.toArray(sFieldsArr);
        return sFieldsArr;

    }
    //Returns list Fields
    public static String[] getListFields(Object entity) {
        Class theClass = entity.getClass();
        Field[] fields = theClass.getDeclaredFields();
        ArrayList<String> sFields = new ArrayList<String>();
        int i=0;
        for (Field f: fields) {
            if(f.getName().contains("list"))
                sFields.add(f.getName()) ;
        }
        String[] sFieldsArr = new String[sFields.size()];
        sFieldsArr = sFields.toArray(sFieldsArr);
        return sFieldsArr;
    }
    public static void setter(Object object, String property, Object value)  throws NoSuchMethodException{
        // Method
        Class theClass = object.getClass();
        try{
        //Methods of type setters are usually like setProperty while Property is defined as property in the Object
        String gMethod = "set"+ property.substring(0,1).toUpperCase()+property.substring(1);
        Method setter = null;
        if(value.getClass()==String.class){
            //If the property starts with the word list than parse the value to string as comma separated
            setter = theClass.getMethod(gMethod,String.class);

        } else if(value.getClass()==Double.class){
            setter = theClass.getMethod(gMethod,double.class);
        }else if (value.getClass() == Integer.class)
        {
            setter = theClass.getMethod(gMethod,Integer.class);
        }
            // invoke
            setter.invoke(object, value);
        }catch (IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
    }

    public static Object getter(Object object, String property)throws Exception {
        // Method
        Object ret = null;
        Class theClass = object.getClass();
            //Methods of type getters are usually like getProperty while property is defined as property in the Object
            String sMethod = "get"+ property.substring(0,1).toUpperCase()+property.substring(1);
            Method getter = theClass.getMethod(sMethod);
            // Invoke
            ret = getter.invoke(object);
        return ret;
    }
}
