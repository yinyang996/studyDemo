package top.mjava.demo;

import redis.clients.jedis.Jedis;

/**
 * redis demo
 * @author zheng
 * */
public class RedisDemo {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("localhost",6379);
        System.out.println(jedis.hget("runoob","fiele1"));
    }
}
