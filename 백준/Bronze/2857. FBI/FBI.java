import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            char[] arr = str.toCharArray();
            for (int j = 0; j < str.length()-2; j++) {
                if(arr[j] == 'F') {
                    if (arr[j+1] == 'B') {
                        if (arr[j+2] == 'I') {
                            flag = true;
                            sb.append(i+1).append(" ");
                            break;
                        }
                    }
                }
            }
        }
        if (!flag) {
            System.out.println("HE GOT AWAY!");
        } else {
            System.out.println(sb);
        }
    }
}