package Sorts;

import java.util.Arrays;
import java.util.stream.Stream;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {11,13,12,5,6};
        System.out.println("Array before sort : " + Arrays.toString(arr));
        System.out.println("Array after sort : " + Arrays.toString(quickSort(arr,0,arr.length-1)));
    }

    static int[] quickSort(int[] arr,int start, int end) {
        if(start < end) {
            int pIndex = partition(arr, start, end);
            quickSort(arr, start, pIndex - 1);
            quickSort(arr, pIndex + 1, end);
        }
        return arr;
    }

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for(int i=start; i<end; i++) {
            if(arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
        int temp = arr[pIndex];
        arr[pIndex] = arr[end];
        arr[end] = temp;
        return pIndex;
    }
}

