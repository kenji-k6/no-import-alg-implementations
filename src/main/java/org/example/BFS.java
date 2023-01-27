package org.example;
import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {
    public static int[][] BFS(ArrayList<ArrayList<Integer>> G, int s) {
        LinkedList<Integer> Q = new LinkedList<Integer>();
        int[] enter = new int[G.size()];
        int[] leave = new int[G.size()];
        boolean[] checked = new boolean[G.size()];

        Q.add(s);
        enter[s] = 0;
        checked[s] = true;
        int T = 1;

        while (!Q.isEmpty()) {
            int u = Q.removeFirst();
            leave[u] = T;
            T++;
            for (int v : G.get(u)) {
                if (!checked[v]) {
                    Q.addLast(v);
                    enter[v] = T;
                    checked[v] = true;
                    T++;
                }
            }
        }

        int[][] res = new int[2][];
        res[0] = enter;
        res[1] = leave;
        return res;

    }

    public static int[][] BFSMat(int[][] G, int s) {
        LinkedList<Integer> Q = new LinkedList<Integer>();
        int[] enter = new int[G.length];
        int[] leave = new int[G.length];
        boolean[] checked = new boolean[G.length];

        Q.add(s);
        enter[s] = 0;
        checked[s] = true;
        int T = 1;

        while (!Q.isEmpty()) {
            int u = Q.removeFirst();
            leave[u] = T;
            T++;
            for(int v = 0; v < G.length; v++) {
                if (G[u][v] != 0 && !checked[v]) {
                    Q.addLast(v);
                    enter[v] = T;
                    checked[v] = true;
                    T++;
                }
            }
        }
        int[][] res = new int[2][];
        res[0] = enter;
        res[1] = leave;
        return res;

    }

    public static void BFSShortestPath(ArrayList<ArrayList<Integer>> G, int s, int t) {
        LinkedList<Integer> Q = new LinkedList<Integer>();
        int[] dist = new int[G.size()];
        int[] pred = new int[G.size()];
        boolean[] checked = new boolean[G.size()];

        dist[s] = 0;
        checked[s]= true;
        Q.addLast(s);
        int T = 1;

        while (!Q.isEmpty()) {
            int u = Q.poll();
            for (int v : G.get(u)) {
                if (!checked[v]) {
                    Q.addLast(v);
                    checked[v] = true;
                    pred[v] = u;
                    dist[v] = dist[pred[v]] + 1;
                }
            }
        }






    }
}
