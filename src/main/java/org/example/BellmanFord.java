package org.example;
import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    public static int[] BellmanFord(int[] e1, int[] e2, int[] edgecost, int s, int n) {


        int[] d = new int[n];
        int[] predecessor = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE;
            predecessor[i] = -1;
        }
        d[s] = 0;



        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < e1.length; j++) {
                int u = e1[j];
                int v = e2[j];
                int cost = edgecost[j];

                if (d[u] != Integer.MAX_VALUE && d[u] + cost < d[v]) {
                    d[v] = d[u] + cost;
                    predecessor[v] = u;
                }
            }
        }

        for (int j = 0; j < e1.length; j++) {
            int u = e1[j];
            int v = e2[j];
            int cost = edgecost[j];

            if (d[u] != Integer.MAX_VALUE && d[u] + cost < d[v]) {
                throw new IllegalArgumentException("Neg Cycle");
            }
        }



        return d;
    }
}
