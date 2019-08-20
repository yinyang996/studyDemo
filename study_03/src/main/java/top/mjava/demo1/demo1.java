package top.mjava.demo1;


import org.omg.Messaging.SyncScopeHelper;

import java.util.*;

public class demo1 {
    public static void main(String[] args) {
        String a="";
        String a2=new String();

        System.out.println(a=="");
        System.out.println(a2=="");
        System.out.println("------------------------------");
        System.out.println(a==null);
        System.out.println(a2==null);
        System.out.println("------------------------------");
        System.out.println(a.length()<=0);
        System.out.println(a2.length()<=0);
        System.out.println("------------------------------");
        System.out.println(a.isEmpty());
        System.out.println(a2.isEmpty());
        System.out.println("------------------------------");

        String b="1";
        String b2=new String("1");
        System.out.println(b==b2);
        System.out.println(b);
        System.out.println(b2);

    }


}
