package study_2020_02.hackerRank.midium;

import java.math.BigInteger;

public class Extralongfactorials {

  public static void main(String[] args) {
    extralongfactorials(25);
  }

  public static void extralongfactorials(int n) {//2076180480
    BigInteger bi = BigInteger.ONE;

    for (int i = 1; i <= n; i++) {
      bi = bi.multiply(BigInteger.valueOf(i));
    }
    System.out.println(bi);
  }
}
