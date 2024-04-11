import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static char[][] map;
    static boolean[][][][] visited;
    static boolean redGoal, blueGoal;
    static Queue<Position> q = new ArrayDeque<>();
    static class Position {
        int redX, redY, blueX, blueY, count;
        public Position() {}
        public Position(int redX, int redY, int blueX, int blueY, int count) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //세로
        m = Integer.parseInt(st.nextToken()); //가로
        map = new char[n][m];
        Position p = new Position();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'R') {
                    p.redX = i; p.redY = j;
                }
                if (map[i][j] == 'B') {
                    p.blueX = i; p.blueY = j;
                }
            }
        }
        p.count = 0;
        q.add(p);
        visited = new boolean[n][m][n][m];
        visited[p.redX][p.redY][p.blueX][p.blueY] = true;
        boolean flag = bfs();

        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    static boolean bfs() {

        while(!q.isEmpty()) {
            Position now = q.poll();
            for (int i = 0; i < 4; i++) {
                int rx = now.redX + dx[i];
                int ry = now.redY + dy[i];
                int bx = now.blueX + dx[i];
                int by = now.blueY + dy[i];
                boolean redflag = false, blueflag = false;
                //빨강 옮기기
                while (map[rx][ry] != '#') {
                    if (map[rx][ry] == 'O') redflag = true;
                    rx += dx[i]; ry += dy[i];
                }
                rx -= dx[i]; ry -= dy[i];
                //파랑 옮기기
                while (map[bx][by] != '#') {
                    if (map[bx][by] == 'O') blueflag = true;
                    bx += dx[i]; by += dy[i];
                }
                bx -= dx[i]; by -= dy[i];
                //목표 달성?
                if (blueflag) continue;
                if (redflag && now.count+1 <= 10) return true;
                //위치 조정
                if (rx == bx && ry == by) {
                    String a = whoIsFirst(i, now);
                    if (a.equals("RED")) {
                        bx -= dx[i];
                        by -= dy[i];
                    } else {
                        rx -= dx[i];
                        ry -= dy[i];
                    }
                }
                if (!visited[rx][ry][bx][by]) {
                    q.add(new Position(rx, ry, bx, by, now.count+1));
                    visited[rx][ry][bx][by] = true;
                    map[rx][ry] = 'r';
                    map[bx][by] = 'b';
//                    print();
                }
            }

        }
        return false;
    }

    static String whoIsFirst(int direction, Position p) {
        if (direction == 0) { //상
            if (p.redX < p.blueX) return "RED";
        } else if (direction == 1) { //하
            if (p.redX > p.blueX) return "RED";
        } else if (direction == 2) { //좌
            if (p.redY < p.blueY) return "RED";
        } else { //우
            if (p.redY > p.blueY) return "RED";
        }
        return "BLUE";
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


}