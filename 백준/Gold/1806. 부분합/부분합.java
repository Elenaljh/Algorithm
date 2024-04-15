import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while (i <= n) { //s보다 큼
            if (arr[i] - arr[j] >= s) {
                min = Integer.min(min, i-j);
                j++;
            } else { //s보다 작음
                i++;
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}