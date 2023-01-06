package org.example;

public class heaptry {

    public static void heapsort(int[] A) {
        int n = A.length;
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(A, i, n);
        }

        for (int i = n-1; i >= 1; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            heapify(A, 0, i);
        }


    }

    public static void heapify(int[] A, int i, int n) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && A[left] > A[largest]) {
            largest = left;
        }
        if (right < n && A[right] > A[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            heapify(A, largest, n);
        }
    }
}
