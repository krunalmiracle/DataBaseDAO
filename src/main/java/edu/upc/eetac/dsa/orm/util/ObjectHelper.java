package edu.upc.eetac.dsa.orm.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class ObjectHelper {

    public static String[] getFields(Object entity) {

        Class theClass = entity.getClass();
        Field[] fields = theClass.getDeclaredFields();
        String[] sFields = new String[fields.length];
        int i=0;
        for (Field f: fields) sFields[i++]=f.getName();
        return sFields;

    }


    public static void setter(Object object, String property, Object value)  throws NoSuchMethodException{
        // Method
        Class theClass = object.getClass();
        try{
        //Methods of type setters are usually like setProperty while property is defined as property in the Object
        String gMethod = "set"+ property.substring(0,1).toUpperCase()+property.substring(1);
        System.out.println("method> " + gMethod);
        Method setter = null;
        if(value.getClass()==String.class){
            //If the property starts with the word list than parse the value to string as comma separated
                if(property.endsWith("s") && property.startsWith("list")){
                    setter = theClass.getMethod(gMethod,String.class);
                }else{
                    setter = theClass.getMethod(gMethod,String.class);
                }

        } else if(value.getClass()==Double.class){
            setter = theClass.getMethod(gMethod,double.class);
        }else if (value.getClass() == int.class)
        {
            setter = theClass.getMethod(gMethod,int.class);
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
        System.out.println("method> "+sMethod);
        Method getter = theClass.getMethod(sMethod,null);
        // Invoke
        ret = getter.invoke(object);
        return ret;
    }
}
