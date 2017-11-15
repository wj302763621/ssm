package com.test.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangjian on 2017/11/9.
 */
public class ObjectToJson {

    public static JSONObject convertorObjectToJson(Object vo) {
        JSONObject obj = new JSONObject();
        Field[] field = vo.getClass().getDeclaredFields();//取得成员名称
        for (int i = 0; i < field.length; i++) {
            System.out.println(field[i].getName());
            Field f = field[i];
            String methodName = "get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
            System.out.println(methodName);
            try {
                Method met = vo.getClass().getMethod(methodName);
                if ("Date".equalsIgnoreCase(f.getType().getSimpleName())) {
                    Date date = (Date) met.invoke(vo);
                    obj.put(f.getName(), new SimpleDateFormat("yyyy-MM-dd").format(date));
                } else {
                    obj.put(f.getName(), met.invoke(vo));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    public static JSONObject convertorListToJson(String name, List<?> all) {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        Iterator<?> iter = all.iterator();
        while(iter.hasNext()){
            array.add(convertorObjectToJson(iter.next()));
        }
        obj.put(name,array);
        return obj;
    }

    public static JSONObject convertorListSplitToJson(String name, List<?> all,Integer allRecorders) {
        JSONObject obj = convertorListToJson(name,all);
        obj.put("allRecorders",allRecorders);
        return obj;
    }
}
