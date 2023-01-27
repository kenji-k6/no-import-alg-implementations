package org.example;

public class FloydWarshall {
    public static int[][][] FloydWarshall(int[] e1, int[] e2, int[] eCost, int n, int m) {

        int[][][] d = new int[n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[0][i][j] = 100;
            }
        }

        for (int i = 0; i < n; i++) {
            d[0][i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int u = e1[i];
            int v = e2[i];

            d[0][u][v] = eCost[i];
        }

        for (int i = 1; i < n; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    d[i][u][v] = Math.min(d[i-1][u][v], d[i-1][u][i]+d[i-1][i][v]);
                }
            }
        }

        return d;
    }
}
