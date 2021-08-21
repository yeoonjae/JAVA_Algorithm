package week01;

import java.math.BigInteger;
import java.util.Scanner;

public class BigSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger big = new BigInteger(sc.next());
        BigInteger big2 = new BigInteger(sc.next());

        BigInteger result = big.add(big2);
        System.out.println(result);
    }

}
