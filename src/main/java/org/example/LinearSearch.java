package org.example;

public class LinearSearch {
    public boolean LinearSearch(int[] A, int b) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] == b) {
                return true;
            }
        }
        return false;
    }
}