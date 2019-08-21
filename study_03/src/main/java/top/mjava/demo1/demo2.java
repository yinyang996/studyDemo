package top.mjava.demo1;

public class demo2 {
    public static void main(String[] args) {
        String s1=new String("t1");
        String s2=new String("t2");
        String s3=new String("t2");

        String s4=new String("t3");
        String s5="t3";
        String s6="t3";

        System.out.println("s2==s3:"+(s2==s3));
        System.out.println("s5==s6:"+(s5==s6));
    }
}
