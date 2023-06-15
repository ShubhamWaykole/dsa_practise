package Sorts;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {11,13,12,5,6};
        System.out.println("Array before sort : " + Arrays.toString(arr));
        System.out.println("Array after sort : " + Arrays.toString(divide(arr,0, arr.length-1)));
    }

    static int[] divide(int[] arr, int left, int right) {
        if(left>=right)
            return arr;
        int mid = left+(right-left)/2;
        divide(arr,left,mid);
        divide(arr,mid+1,right);
        merge(arr, left, mid, right);
        return arr;
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int index1 = left;
        int index2 = mid+1;
        int[] temp = new int[right-left+1];
        int cnt = 0;
        while(index1 <= mid && index2 <=right) {
            if(arr[index1] > arr[index2])
                temp[cnt++] = arr[index2++];
            else
                temp[cnt++] = arr[index1++];
        }
        while(index1 <= mid)
                temp[cnt++] = arr[index1++];
        while(index2 <= right)
            temp[cnt++] = arr[index2++];
        for(int i=0,j=left;i< temp.length;i++,j++)
            arr[j] = temp[i];
    }
}
