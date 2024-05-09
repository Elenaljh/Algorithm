import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int testCase = Integer.parseInt(br.readLine());
         StringBuilder sb = new StringBuilder();

         //작은 수 저장
         long[] smallest = new long[101];
         Arrays.fill(smallest, Long.MAX_VALUE);
         String[] unitNumbers = new String[] {"", "", "1", "7", "4", "2", "0", "8"};
         smallest[2] = 1; smallest[3] = 7; smallest[4] = 4; smallest[5] = 2; smallest[6] = 6;
         smallest[7] = 8; smallest[8] = 10;
         for (int i = 9; i <= 100; i++) {
             for (int j = 2; j < 8; j++) {
                 String tmpNumber = smallest[i-j] + unitNumbers[j];
                 smallest[i] = Math.min(Long.parseLong(tmpNumber), smallest[i]);
             }
         }

         //큰 수 저장
         String[] largest = new String[101];
         for (int i = 2; i <= 100; i++) {
             if (i%2 == 0) {
                 largest[i] = "1".repeat(i/2);
             } else {
                 largest[i] = "7" + "1".repeat((i-3)/2);
             }
         }

         for (int test = 0; test < testCase; test++) {
             int n = Integer.parseInt(br.readLine());
             sb.append(smallest[n]).append(" ").append(largest[n]).append("\n");
         }
         System.out.println(sb);
    }
}

/*
각 숫자 만드는데 필요한 성냥개비 수
0. 6개
1. 2개
2. 5개
3. 5개
4. 4개
5. 5개
6. 6개
7. 3개
8. 7개
9. 6개

- 가장 작은 숫자 만드는 법 : 가능한 숫자를 적게 만든다. 필요한 성냥개비의 수가 같은 경우 가장 작은 수를 만든다. 만든 숫자를 오름차순으로 정렬한다.
- 가장 큰 숫자 만드는 법 : 가능한 숫자를 많이 만든다. 필요한 성냥개비의 수가 같은 경우 가장 큰 수를 만든다. 만든 숫자를 내림차순으로 정렬한다.
- largest[101] = { 0, 0, 1,  }

                                      6
- smallest[101] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 } -> 성냥개비 개수
- smallest[101] = { 0, 0, 1, 7, 4, 2, 0, 8, 10,18, 22, 20, 28, 68, 88, 108   } -> 만들 수 있는 가장 작은 수
*/
