package J0430;

public class Main3 {
    public static void main(String[] args) {
        //finalは変数の中身を変更できなくする役割がある
        //要は変数を定数に変更する
        final double pi = 3.14;   //円周率
        int pie = 5;    //食べるパイの半径
        System.out.println("半径" + pie + "cmのパイの面積は");
        System.out.println(pie * pie * pi);
        System.out.println("パイの半径を倍にします");
        pie = 10;
        System.out.println("半径" + pie + "cmのパイの半径は");
        System.out.println(pie * pie * pi);
    }
}
