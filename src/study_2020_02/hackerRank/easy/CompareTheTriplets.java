package study_2020_02.hackerRank.easy;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class CompareTheTriplets {

  public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

    // 5 6 7
    // 3 6 10
    int aPoint = 0;
    int bPoint = 0;
    for (int i = 0; i < a.size(); i++) {
      if(a.get(i) > b.get(i)) aPoint++;
      else if (a.get(i) < b.get(i)) bPoint++;
    }
    System.out.println(List.of(aPoint, bPoint));
    return List.of(aPoint, bPoint);
  }

  public static void main(String[] args) throws IOException {
    CompareTheTriplets compareTheTriplets = new CompareTheTriplets();
    List<Integer> a = List.of(5, 6, 7);
    List<Integer> b = List.of(3,6,10);
    System.out.println(CompareTheTriplets.compareTriplets(a, b));

  }
}
