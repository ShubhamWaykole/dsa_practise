package Sorts;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        String s1 = "ABC";
        s1 = s1+"xyz";
        System.out.println(s1);
        int[] arr = {11,13,12,5,6};
        System.out.println("Array before sort : " + Arrays.toString(arr));
        System.out.println("Array after sort : " + Arrays.toString(bubbleSort(arr)));
    }

    static int[] bubbleSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

}
