import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] liquids = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) liquids[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(liquids);
        int min = 0;
        int max = n-1;
        int[] result = new int[2];
        int answer = Integer.MAX_VALUE;
        while (min < max) {
            int ph = liquids[max]+liquids[min];
            if (Math.abs(ph) < answer) {
                result = new int[]{liquids[min], liquids[max]};
                answer = Math.abs(ph);
            }
            if (ph < 0) {
                min++;
            } else {
                max--;
            }
        }
        System.out.println(result[0]+" "+result[1]);
    }
}