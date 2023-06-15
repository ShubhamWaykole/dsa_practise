package Arrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromArray {
    public static void main(String args[])
    {
        int[] intArray = {1,2,5,2,7,1,8,0};
        RemoveDuplicatesFromArray obj = new RemoveDuplicatesFromArray();
        obj.removeDuplicatesAndPrint(intArray);
    }

    public void removeDuplicatesAndPrint(int[] arr) {
        System.out.println("Array with duplicates : " + Arrays.toString(arr));
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
        for(int number : arr)
            set.add(number);
        System.out.print("Array wout duplicated : ");
        set.forEach((n) -> System.out.print(n + " "));
    }
}
