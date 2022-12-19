package org.example;

public class LinearSearch {
    public static int linearSearch(int[] A, int b) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] == b) {
                return i;
            }
        }
        return -1;
    }
}