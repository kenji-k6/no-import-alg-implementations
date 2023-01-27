package org.example;
import java.util.ArrayList;

public class DFS {
    public static int[][] DFS(ArrayList<ArrayList<Integer>> G) {
        int[] pre = new int[G.size()];
        int[] post = new int[G.size()];
        boolean[] checked = new boolean[G.size()];
        int count = 1;
        for (int i = 0; i < G.size(); i++) {
            if (!checked[i]) {
                count = visit(G, i, count, checked, pre, post);
            }
        }
        int[][] res = new int[2][];
        res[0] = pre;
        res[1] = post;
        return res;
    }

    public static int visit(ArrayList<ArrayList<Integer>> G, int u, int count, boolean[] checked, int[] pre, int[] post) {
        int T = count;
        pre[u] = count;
        T++;
        checked[u] = true;
        for (int v : G.get(u)) {
            if (!checked[v]) {
                T = visit(G, v, T, checked, pre, post);
            }
        }
        post[u] = T;
        T++;
        return T;
    }

    public static int[][] DFSMat(int[][] G) {
        int[][] res = new int[2][];
        int[] pre = new int[G.length];
        int[] post = new int[G.length];
        boolean[] checked = new boolean[G.length];
        int count = 1;

        for (int i = 0; i < G.length; i++) {
            if (!checked[i]) {
                count = visitMat(G, i, count, checked, pre, post);
            }
        }
        res[0] = pre;
        res[1] = post;
        return res;
    }

    public static int visitMat(int[][] G, int u, int count, boolean[] checked, int[] pre, int[] post) {
        System.out.println(u);
        int T = count;
        pre[u] = count;
        T++;
        checked[u] = true;

        for (int v = 0; v < G.length; v++) {
            if (G[u][v] != 0 && !checked[v]) {
                T = visitMat(G, v, T, checked, pre, post);
            }
        }
        post[u] = T;
        T++;
        return T;
    }

}

