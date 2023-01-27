package org.example;
import java.util.PriorityQueue;
import java.util.ArrayList;
public class JohnsonJohnson {


    public static int[][] johnson(int[] e1, int[] e2, int[] eCost, int n, int m) {
        int[] newE1 = new int[m+n];
        int[] newE2 = new int[m+n];
        int[] newEcost = new int[m+n];
        for (int i = 0; i < m; i++) {
            newE1[i] = e1[i];
            newE2[i] = e2[i];
            newEcost[i] = eCost[i];
        }
        for (int i = m; i < m+n; i++) {
            newE1[i] = n;
            newE2[i] = i-m;
            newEcost[i] = 0;
        }

        int[] h = bf(newE1, newE2, newEcost, n+1, m+n, n);

        int[] hCost = new int[m];

        for (int i = 0; i < m; i++) {
            int cost = eCost[i];
            int u = e1[i];
            int v = e2[i];
            hCost[i] = cost + h[u] - h[v];
        }

        int[][] d = new int[n][n];


        for (int i = 0; i < n; i++) {
            d[i] = dijk(e1, e2, hCost, n, m, i);
        }

        return d;
    }

    public static int[] dijk(int[] e1, int[] e2, int[] eCost, int n, int m, int s) {

        ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < m; i++) {
            int u = e1[i];
            int v = e2[i];
            int cost = eCost[i];
            adj.get(u).add(new Edge(v, cost));
        }

        int[] d = new int[n];
        boolean[] checked = new boolean[n];








        PriorityQueue<Node> H = new PriorityQueue<Node>();



        for (int i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE-1;
        }
        d[s] = 0;

        for (int i = 0; i < n; i++) {
            H.add(new Node(i, d[i]));
        }




        while (!H.isEmpty()) {

            int vS = H.poll().index;
            checked[vS] = true;

            for (Edge e : adj.get(vS)) {
                int v = e.v;
                if (!checked[v]) {
                    if (d[v] == Integer.MAX_VALUE-1) {
                        d[v] = d[vS]+ e.cost;
                    }else {
                        d[v] = Math.min(d[v], d[vS]+e.cost);
                    }
                    H.add(new Node(v, d[v]));
                }
            }
        }


        return d;
    }

    static class Edge {
        int v;
        int cost;
        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static class Node implements Comparable<Node>{
        int index;
        int d;

        public Node(int index, int d) {
            this.index = index;
            this.d = d;
        }


        public int compareTo(Node n2) {
            return this.d-n2.d;
        }

    }

    public static int[] bf(int[] e1, int[] e2, int[] eCost, int n, int m, int s) {
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE-1;
        }
        d[s] = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m; j++) {
                int u = e1[j];
                int v = e2[j];
                int cost = eCost[j];
                if (d[u] != Integer.MAX_VALUE-1 && d[u] +cost < d[v]) {
                    d[v] = d[u] + cost;
                }
            }
        }
        return d;
    }
}
