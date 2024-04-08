import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        long low = 0;
        long high = houses[n-1] - houses[0];
        long mid = 0;
        while (low <= high) { //실질적으로 low==high이거나 low+1 == high일때까지 진행됨
            mid = (low+high) >>> 1;

            int count = 1;
            int pre = houses[0];
            for (int i = 1; i < n; i++) {
                if (houses[i] >= mid + pre) {
                    count++;
                    pre = houses[i];
                }
            }

            if (count >= c) {
                low = mid + 1; //low가 정답인 dist에 도달한 후 1 커짐 -> 이 상태로 while 벗어남
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low-1); //low-1을 반환해야 함
    }
}