import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] numbers = str.split("[+]|-");
        int n = numbers.length;
        int[] num = new int[n];
        for (int i = 0; i < n; i++){
            num[i] = Integer.parseInt(numbers[i]);
        }
        char[] arr = new char[n-1]; //연산부호
        boolean flag = false; //앞에 - 있음
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            char aa = str.charAt(i);
            if (flag) { //앞에 - 잇ㅇ,ㅡㅁ
                if (aa == '-' || aa == '+') {
                    arr[index] = '-';
                    index++;
                }
            } else {
                if (aa == '+') {
                    arr[index] = '+';
                    index++;
                } else if (aa=='-') {
                    arr[index] = '-';
                    index++;
                    flag = true;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res += num[i];
            } else {
                if (arr[i-1] == '-') {
                    res -= num[i];
                } else {
                    res += num[i];
                }
            }
        }
        System.out.println(res);
    }
}