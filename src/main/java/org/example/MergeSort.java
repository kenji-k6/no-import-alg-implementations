package org.example;

public class MergeSort {
    public static void mergeSort(int[] A, int l, int r) {
        if (l < r) {
            int mid = l + (r-l)/2;
            mergeSort(A,l,mid);
            mergeSort(A, mid+1, r);
            merge(A, l, mid, r);
        }


    }

    public static void merge(int[] A, int l, int m, int r) {
        int nl = m - l + 1;
        int nr = r - m;

        /* Create temp arrays */
        int L[] = new int[nl];
        int R[] = new int[nr];

        /*Copy data to temp arrays*/
        for (int i = 0; i < nl; ++i)
            L[i] = A[l + i];
        for (int j = 0; j < nr; ++j)
            R[j] = A[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < nl && j < nr) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            }
            else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < nl) {
            A[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < nr) {
            A[k] = R[j];
            j++;
            k++;
        }


    }
}
