package org.example;

public class BinarySearch {

    //regular recursive binarySearch, returns index if found, else -1;
    //l = 0,  r = n-1 initially
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





    //iterative binarySearch, returns index if found, else returns index of next closest element in array
    public static int binarySearchClosestIt(int[] A, int b) {
        int n = A.length;
        int l = 0;
        int r = n-1;
        int mid = 0;

        if (A[0] >= b) {
            return 0;
        }
        if (A[n-1] <= b) {
            return n-1;
        }
        while (l <= r) {
            mid = (l+r)/2;
            if (A[mid] == b) {
                return mid;
            }
            if (A[mid] > b) {
                if (mid > 0 && A[mid-1] < b) {
                    if (Math.abs(b-A[mid]) <= Math.abs(b-A[mid-1])) {
                        return mid;
                    }else{
                        return mid-1;
                    }
                }
                r = mid-1;
            }
            if (A[mid] < b) {
                if (mid < n-1 && A[mid+1] > b) {
                    if (Math.abs(b-A[mid]) <= Math.abs(b-A[mid+1])) {
                        return mid;
                    }else{
                        return mid+1;
                    }
                }
                l = mid+1;
            }
        }
        return mid;
    }
}



