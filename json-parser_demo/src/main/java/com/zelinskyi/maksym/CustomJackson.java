package com.zelinskyi.maksym;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomJackson {

    public static void main(String[] args) {
        var reader = new BufferedReader(new InputStreamReader(CustomJackson.class.getClassLoader().getResourceAsStream("user.json")));
        User user = jsonToObj(reader.lines().collect(Collectors.joining()), User.class);
        System.out.println(user.firstname +" "+ user.lastname);
    }

    public static <T> T jsonToObj(String json, Class<T> objClass){
        T result = null;
        json = json.replaceAll("[\\{\\}\\\"]", "");

        String[] data =json.split(",");
       Map<String, String> fieldMap = new HashMap<>();
       for(String s : data){
           String key = s.substring(0, s.indexOf(" : ")).replaceAll(" ", "");
           String value = s.substring(s.indexOf(" : ")+3);
           fieldMap.put(key, value);
       }

        try {
            Constructor constructor = objClass.getConstructor();
            result = (T)constructor.newInstance();
            Field[] fields = objClass.getFields();
            for(Field f : fields){
                String fieldName = f.getName();
                if(fieldMap.containsKey(fieldName)){
                    objClass.getField(fieldName).set(result, fieldMap.get(fieldName));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static class User{
       public String firstname;
       public String lastname;
    }
}
