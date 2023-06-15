package Arrays;

public class ArraysComplexImpProbs {

    public static void main(String[] args) {
        int arr[] = {2,-3,1,3,-2,4,1,2};
        int arr1[] = {3,1,2,5,8,2};
        int arr2[] = {3,6,1,3};
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");
        printLargestSumContiguousArray(arr);
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");
        findMaxProfit(arr1);
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");
        findMaxProfit(arr2);
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");
    }

    static void findMaxProfit(int arr[]) {
        System.out.println("Array represent price of stock in day wise sequence");
        System.out.print("Orininal array is: ");
        for (int ele:arr)
            System.out.print(ele + " ");
        System.out.println();
        int buy_day=0,sell_day=0;
        int max_profit = Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++) {
            for(int j=i+1;j< arr.length;j++) {
                int diff = arr[j] - arr[i];
                if(diff > max_profit) {
                    max_profit = diff;
                    buy_day = i;
                    sell_day = j;
                }
            }
        }
        System.out.println("Max Profit: " + max_profit);
        System.out.println("Buy day: " + buy_day);
        System.out.println("Sell day: " + sell_day);
    }
    static void printLargestSumContiguousArray(int arr[]) {
        System.out.print("Orininal array is: ");
        for (int ele:arr)
            System.out.print(ele + " ");
        System.out.println();
        int start=0,end=0,s=0,max_ending_here=0;
        int max_so_far = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            max_ending_here += arr[i];
            if(max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
            if(max_ending_here < 0) {
                max_ending_here = 0;
                s = i+1;
            }
        }
        System.out.println("Max sum of contiguous array is : " + max_so_far);
        System.out.println("start index: "+start);
        System.out.println("end index: "+end);
    }
}
