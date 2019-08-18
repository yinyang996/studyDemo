package top.mjava.demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zheng
 * 对比A，B两个List ,去处共同存在的元素
 * 去同存异算法
 * */
public class demo1 {
    public static void main(String[] args) {
        List A=new ArrayList();
        HashMap<String, String> map=new HashMap<>();
        map.put("12", "你好");
        map.put("13", "世界");
        A.add(map);
        A.add("12");
        A.add(444);
        A.add(4441);
        A.add("123a");
        A.add("1243");
        List B=new ArrayList();
        B.add("12");
        B.add(444);
        B.add("123");
        B.add("12378");
        B.add("124");
        B.add("124999");
        B.add("1247771");
        B.add("1247772");
        B.add("1247773");
        B.add("1247774");
        B.add("1247775");
        B.add("1247776");
        B.add("1247778");
        B.add("1247779");

        getNotIn(B,A);

        System.out.println(A.toString());
        System.out.println(B.toString());

    }


    public static void getNotIn(List A,List B){
        long startTime=System.nanoTime();
        for (Object a:A) {
            if(B.contains(a)) {
                A.remove(a);
                B.remove(a);
                getNotIn(A,B);
                return;
            }
        }
        long endTime=System.nanoTime();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
    }


}
