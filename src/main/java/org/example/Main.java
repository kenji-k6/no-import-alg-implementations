package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] A = new int[10000001];
        Random rand = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i] = rand.nextInt(Integer.MAX_VALUE-10)+3;
        }


        System.out.println(isSorted.isSorted(A));
        MergeSort.mergeStry(A, 0, A.length-1);
        System.out.println(isSorted.isSorted(A));


//        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
//        int a = 0;
//        int b = 1;
//        int c = 2;
//        int d = 3;
//        int e = 4;
//        int f = 5;
//        int g = 6;
//        int h = 7;
//
//        for (int i = 0; i < 8; i++) {
//            adj.add(new ArrayList<Integer>());
//        }
//        adj.get(a).add(b);
//        adj.get(a).add(c);
//        adj.get(a).add(f);
//
//        adj.get(b).add(e);
//
//        adj.get(c).add(d);
//
//        adj.get(d).add(a);
//        adj.get(d).add(h);
//
//        adj.get(e).add(f);
//        adj.get(e).add(g);
//        adj.get(e).add(h);
//
//        adj.get(f).add(b);
//        adj.get(f).add(g);
//
//        adj.get(h).add(g);
//
//
//
//        int[][] adjMatrix = new int[adj.size()][adj.size()];
//
//        for (int u = 0; u < adj.size(); u++) {
//            for (int v : adj.get(u)) {
//                adjMatrix[u][v] = 1;
//            }
//        }
//
//        int[] e1 = {0, 1, 2, 3, 4, 5, 6, 3};
//        int[] e2 = {1, 2, 3, 4, 5, 6, 3, 0};
//        int[] cost = {2, 5, 3, 9, 1, 6, 11, 7};
//
//        int[] e11 = {0, 0, 1, 2, 2, 3};
//        int[] e12 = {2, 3, 3, 0, 1, 2};
//        int[] e1Cost = {1,1,1,1,1,1};
//
//
//
//        int[][][]ddd = FloydWarshall.FloydWarshall(e11, e12, e1Cost,4, 6);
//        int[][]d2 = JohnsonJohnson.johnson(e11, e12, e1Cost, 4, 6);
//
//       System.out.println(Arrays.deepToString(ddd[3]));
//        System.out.println(Arrays.deepToString(d2));



    }
}