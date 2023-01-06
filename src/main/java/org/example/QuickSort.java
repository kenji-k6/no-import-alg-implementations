package org.example;

public class QuickSort {
    public static void quickSort(int[] A, int l, int r) {
        if (l < r) {
            int k = split(A, l, r);

            quickSort(A,l,k-1);
            quickSort(A, k+1, r);
        }
    }

    public static int split(int[] A, int l, int r) {
       int p = A[r];
       int i = l-1;

       for (int j = l; j <= r-1; j++) {
           if (A[j] < p) {
               i++;
               swap(A, i, j);
           }
       }
       swap(A, i+1, r);
        return i+1;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
