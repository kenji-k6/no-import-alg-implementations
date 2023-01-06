package org.example;

public class SelectionSort {
    public static void selectionSort(int[] A) {
        for (int i = 0; i < A.length-1; i++) {
            int j = i;
            for (int k = i; k < A.length; k++) {
                if (A[j] > A[k]) {
                    j = k;
                }
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

}
