package org.example;

public class isSorted {
    public static boolean isSorted(int[] A) {
        for (int i = 0; i < A.length-1; i++) {
            if (A[i]> A[i+1]) {
                return false;
            }
        }
        return true;
    }

}
