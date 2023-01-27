package org.example;
import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {

    public static int Kruskal(int[] e1, int[] e2, int[] eCost, int n, int m) {

        Edge[] edgeArr = new Edge[m];

        for (int i = 0; i < m; i++) {
            edgeArr[i] = new Edge(e1[i], e2[i], eCost[i]);
        }

        Arrays.sort(edgeArr, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w-o2.w;
            }
        });


        unionfind uf = new unionfind(n);

        int k = 0;
        int mst = 0;
        int cost = 0;

        while (mst < n-1 && k < m) {
            Edge e = edgeArr[k];
            int u = uf.find(e.u);
            int v = uf.find(e.v);

            if (u != v) {
                uf.union(u, v);
                mst += 1;
                cost += e.w;
            }
            k++;
        }



        return cost;
    }

    static class Edge {
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }


    static class unionfind {
        int[] rep;
        int[] rank;

        unionfind(int n) {
            create(n);
        }

        public void create(int n) {
            this.rep = new int[n];
            this.rank = new int[n];

            for (int i = 0; i < n; i++) {
                rep[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int u) {
            if (rep[u] != u) {
                rep[u] = find(rep[u]);
            }
            return rep[u];
        }

        public void union(int u, int v) {
            int repU = find(u);
            int repV = find(v);

            if (rank[repU] > rank[repV]) {
                rep[repV] = repU;
            }else if (rank[repV] > rank[repU]) {
                rep[repU] = repV;
            }else{
                rep[repV] = repU;
                rank[repU] += 1;
            }
        }
    }
}
