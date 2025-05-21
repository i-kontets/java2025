package j0514;

public class Mein {
    public static void main(String[] args) {
        int a;
        int b;
        //値を代入
        a=20;
        b=a+5;
        System.out.println(a);
        System.out.println(b);

        //10進数
        int c=10;
        //16進数
        //0~9,A~F
        int d=0x10;
        //8進数
        int e=07;
        //2進数
        int f=0b0011;

        System.out.println("10進数 ："+c);
        System.out.println("16進数 ："+d);
        System.out.println("8進数 ："+e);
        System.out.println("2進数 ："+f);
    }
}