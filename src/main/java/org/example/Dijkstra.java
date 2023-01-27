package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Dijkstra { // Only Positive cost

    public static int[] Dijkstra(int[] e1, int[] e2, int[] edgecost, int s, int n) {

        ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < e1.length; i++) {
            int u = e1[i];
            int v = e2[i];
            int cost = edgecost[i];

            adj.get(u).add(new Edge(v, cost));
        }

        int[] d = new int[n];
        boolean[] checked = new boolean[n];

        for (int i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[s] = 0;

        PriorityQueue<Node> H = new PriorityQueue<Node>();

        for (int i = 0; i < n; i++) {
            H.add(new Node(i, d[i]));
        }

        while (!H.isEmpty()) {
            int vS = H.poll().u;
            checked[vS] = true;

            for (Edge e : adj.get(vS)) {
                int v = e.dest;
                if (!checked[v]) {
                    if (d[v] == Integer.MAX_VALUE) {
                        d[v] = d[vS] + e.cost;
                    }else{
                        d[v] = Math.min(d[v], d[vS] + e.cost);
                    }
                    H.add(new Node(v, d[v]));
                }
            }

        }

        return d;
    }



}

class Node implements Comparable<Node>{
    int u;
    int min;


    public Node(int u, int min) {
        this.u = u;
        this.min = min;
    }

    public int compareTo(Node a) {
        return this.min-a.min;
    }
}

class Edge {
    int dest;
    int cost;

    public Edge(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}





