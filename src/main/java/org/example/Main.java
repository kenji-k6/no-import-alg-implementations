package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] A = new int[10000000];
        Random rand = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i] = rand.nextInt(Integer.MAX_VALUE-10)+3;
        }

        int[] B = {1,2,3,4,5,6,7,8};
        System.out.println(isSorted.isSorted(A));
        MergeSort.mergeSort(A, 0, A.length-1);
        System.out.println(isSorted.isSorted(A));
    }
}