package src.common;

public class bintodec {
    public static int bintodeci(int n) {
        int dec = 0;
        int pow = 0;
        while (n > 0) {
            int last = n % 10;
            dec = dec + last * (int) Math.pow(2, pow);
            pow++;
            n = n / 10;
        }
        return dec;
    }

    public static void main(String args[]) {
        int n = 101;
        System.out.println(bintodeci(n));
    }
}
