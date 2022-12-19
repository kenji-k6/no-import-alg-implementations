package org.example;

public class Main {
    public static void main(String[] args) {

        int[] A = {3,5,7,11,13,17,19,23,29,31};
        int n = A.length;
        for (int i = 0; i < n; i++) {
            System.out.println(BinarySearch.binarySearchIt(A, A[i]));
        }
    }
}