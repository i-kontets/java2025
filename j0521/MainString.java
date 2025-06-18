package j0521;

public class MainString {
    public static void main(String[] args) {
        int a=10;
        double b=13.3;
        //変数aは10です。変数bは13.3です。
        String msg1="変数aは"+a+"です。";
        String msg2="変数aは"+b+"です。";
        System.out.println(msg1);
        System.out.println(msg2);
        //Cの場合
        //printf("変数aは%dです。",a);
        //Javaの場合
        String msg3 = String.format("変数aは%dです。",a);
        String msg4 = String.format("変数bは%.4fです。",b);
        System.out.println(msg3);
        System.out.println(msg4);
    }
}
