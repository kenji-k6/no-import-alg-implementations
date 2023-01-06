package org.example;

public class InsertionSort {
    public static void insertionSort(int[] A) {
        int n = A.length;
        for (int i = 1; i < n; i++) {
            int k = A[i];
            int j = i-1;

            while (j >= 0 && A[j]  > k) {
                A[j+1] = A[j];
                j = j-1;
            }
            A[j+1] = k;
        }
    }

}
