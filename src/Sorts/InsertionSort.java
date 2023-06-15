package Sorts;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {11,13,12,5,6};
        System.out.println("Array before sort : " + Arrays.toString(arr));
        System.out.println("Array after sort : " + Arrays.toString(insertionSort(arr)));
    }

    static int[] insertionSort(int[] a) {
        for(int i=1; i<a.length ; i++ ) {
            int key = a[i];
            int j = i-1;

            while(j >= 0 && a[j] > key) {
                a[j+1] = a[j];
                j -= 1;
            }
            a[j+1] = key;

        }
        return a;
    }

}
