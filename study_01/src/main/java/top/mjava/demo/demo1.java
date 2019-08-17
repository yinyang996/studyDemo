package top.mjava.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

/**
 * 递归算法-获取json指定key的所有值
 * @author zheng
 * */
public class demo1 {
    public static void main(String[] args) {
        try {
            File file=new File(demo1.class.getResource("/2.json").getPath());
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line="";
            StringBuffer json=new StringBuffer();
            while ((line=bufferedReader.readLine())!=null){
                json.append(line);
            }

            JSONObject j3=JSON.parseObject(json.toString());
            List<String> mid=new ArrayList<>();
            getJSONValue(j3,"interfaceId",mid);
            System.out.println(mid.toString());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void getJSONValue(JSONObject json,String k,List<String> list){
        for (Object j:json.keySet()){
            if(isJSONObj(json.get(j))){
                //是对象
                JSONObject j2= JSON.parseObject(json.get(j).toString());
                getJSONValue(j2,k,list);
            }else if(isJSONArray(json.get(j))){
                JSONArray j3=JSON.parseArray(json.get(j).toString());
                //是数组
                getJSONValue(j3,k,list);
            }else if(j==k){
                //是字符串
                list.add(json.get(j).toString());
            }
        }
    }

    public static void getJSONValue(JSONArray json,String k,List<String> list){
        for (Object j:json){
            if(isJSONObj(j)){
                //是对象
                JSONObject j2= JSON.parseObject(j.toString());
                getJSONValue(j2,k,list);
            }else if(isJSONArray(j)){
                //是数组
                JSONArray j3=JSON.parseArray(j.toString());
                getJSONValue(j3,k,list);
            }
        }
    }

    public static boolean isJSONObj(Object json){
        return json instanceof JSONObject;
    }

    public static boolean isJSONArray(Object json){
        return json instanceof JSONArray;
    }
}
