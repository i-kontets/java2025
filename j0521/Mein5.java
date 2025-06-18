package j0521;

public class Mein5 {//クラス定義(クラスブロック)
    //メイン定義(メソッドブロック)
    public static void main(String[] args) {//mainメソッド
        String name="すがわら";
        System.out.println(name);
        int num=test(10,100);
        System.out.println(num);
    }
    public static int test(int x,int y) {
        System.out.println("テストメソッドが実行された");
        System.out.println(x);
        System.out.println(y);
        return 1+1;
    }
}