package boj.dp;

import java.io.*;
import java.util.StringTokenizer;

public class No11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    arr[i][j] = Math.max(arr[i][j] + arr[i - 1][j], arr[i][j] + arr[i][j - 1]);
                } else if (i - 1 >= 0 && j - 1 < 0) {
                    arr[i][j] = arr[i][j] + arr[i - 1][j];
                } else if (i - 1 < 0 && j - 1 >= 0) {
                    arr[i][j] = arr[i][j] + arr[i][j - 1];
                }
            }
        }
        bw.write(String.valueOf(arr[n - 1][m - 1]));
        bw.close();
    }
}