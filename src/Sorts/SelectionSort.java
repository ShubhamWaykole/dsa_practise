package Sorts;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {11,13,12,5,6};
        System.out.println("Array before sort : " + Arrays.toString(arr));
        System.out.println("Array after sort : " + Arrays.toString(selectionSort(arr)));
    }

    static int[] selectionSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            int min_index = i;
            for( int j=i+1; j<arr.length;j++) {
                if(arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
