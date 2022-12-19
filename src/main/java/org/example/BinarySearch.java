package org.example;

public class BinarySearch {

    //regular recursive binarySearch, returns index if found, else -1;
    public static int binarySearch(int[] A, int l, int r, int b) {
        if (r >= l)  {
            int mid = l + (r-l)/2;

            if (A[mid] == b) {
                return mid;
            }
            if (A[mid] > b) {
                return binarySearch(A, l, mid-1, b);
            }else{
                return binarySearch(A, mid+1, r, b);
            }
        }
        return -1;
    }


    //regular iterative binarySearch, returns index if found, else -1;
    public static int binarySearchIt(int[] A, int b) {
        int n = A.length;
        int l = 0;
        int r = n-1;

        while (l <= r) {
            int mid = (l+r)/2;
            if (A[mid] == b) {
                return mid;
            }
            if (A[mid] > b) {
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return -1;
    }
}
