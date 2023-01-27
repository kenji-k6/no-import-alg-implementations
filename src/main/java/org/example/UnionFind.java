package org.example;
import java.util.LinkedList;

public class UnionFind {

    int[] parent;
    int[] rank;

    UnionFind(int n) {
        create(n);
    }

    void create (int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find (int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union (int x, int y) {

        int xroot = find(x);
        int yroot = find(y);

        if (rank[xroot] < rank[yroot]) {
            parent[xroot] = yroot;
        }else if (rank[xroot] > rank[yroot]) {
            parent[yroot] = xroot;
        }else{
            parent[yroot] = xroot;
            rank[xroot] += 1;
        }

    }

}
