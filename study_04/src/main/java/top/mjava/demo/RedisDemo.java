package top.mjava.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.HashMap;

/**
 * redis demo
 * @author zheng
 * */
public class RedisDemo {
    public static void main(String[] args) {


        try {
            Jedis jedis=new Jedis("localhost",6379);
            HashMap<String,String> errorList= (HashMap<String, String>) jedis.hgetAll("errorList");
            JSONObject json= JSON.parseObject(JSON.toJSONString(errorList));
            System.out.println(json.get("3df480fb50cf4b8d95e29fc2b8942d02"));
            File f=new File("/home/zheng/errorlist2.json");
            f.createNewFile();
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(f));
            bufferedWriter.write(json.toJSONString());
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {

        }

    }
}
