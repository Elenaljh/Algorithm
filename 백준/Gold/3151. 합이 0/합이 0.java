import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(Integer.parseInt(st.nextToken()));
        arr.sort(Comparator.naturalOrder());
        long count = 0;

        while (arr.size()>=3) {
            int A = arr.remove(arr.size()-1);
            int min = 0;
            int max = arr.size()-1;
            while (min < max) {
                int B = arr.get(min);
                int C = arr.get(max);
                int sum = A + B + C;
                if (sum == 0) {
                    if (Objects.equals(B, C)) {
                        long tmp = combination(max-min+1);
                        count += tmp;
                        break;
                    } else {
                        int min_count = 0; int max_count = 0;
                        while (B == arr.get(min)) {
                            min++;
                            min_count++;
                        }
                        while (C == arr.get(max)) {
                            max--;
                            max_count++;
                        }
                        count += (long) min_count *max_count;
                    }
                } else if (sum < 0) {
                    min++;
                } else if (sum > 0) {
                    max--;
                }
            }
        }
        System.out.println(count);
    }

    static long combination (int n) {
        return ((long) n * (n-1)) / 2;
    }
}