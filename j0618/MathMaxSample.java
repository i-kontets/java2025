package j0618;
public class MathMaxSample {
    public static void main(String[] args) {
        int a = 10;
        int b = 25;
        int c = 17;

        // 2つの値の最大値
        int minAB = Math.min(a, b);
        System.out.println(a + "と" + b + "の最小値は: " + minAB);

        // 3つの値の最大値
        int maxABC = Math.max(a, Math.max(b, c));
        System.out.println(a + "と" + b + "と" + c + "の最大値は: " + maxABC);
    }
}