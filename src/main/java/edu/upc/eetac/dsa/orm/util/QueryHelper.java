package edu.upc.eetac.dsa.orm.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueryHelper {

    public static String createQueryINSERT(Object entity) {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String [] fields = ObjectHelper.getFields(entity);

        sb.append("ID");
        for (String field: fields) {
            sb.append(", ").append(field);
        }

        sb.append(") VALUES (?");

        for (String field: fields) {
            sb.append(", ?");
        }

        sb.append(")");

        return sb.toString();
    }

    public String stringifyList(List<String> listStr){
        String rs = "";
        for (String str : listStr) {
            rs = rs + ',' + str;
        }
        return rs;
    }
    public List<String> StrCommaSeparetedToList(String resultStr){
        List<String> rl = new LinkedList<String>();
        String[] arrID = resultStr.split(",");
        rl = Arrays.asList(arrID);
        return rl;
    }
    public static String createQuerySELECT(Object entity) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE ID = ?");

        return sb.toString();
    }
    public static String createQueryDELETE(Object entity){
        StringBuffer sb = new StringBuffer("DELETE FROM ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("WHERE ID = ?");
        return sb.toString();
    }

}
