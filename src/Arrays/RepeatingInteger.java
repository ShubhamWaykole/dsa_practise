package Arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RepeatingInteger {
    public static void main(String args[]) {
        int[] intArray = {1,2,5,2,7,8,5,0};
        RepeatingInteger obj = new RepeatingInteger();
        System.out.println("FIrst repeating number is : " +  obj.findFirstRepeatingNumber(intArray));
    }

    private int findFirstRepeatingNumber(int[] intArray) {

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for(int num : intArray) {
            if(map.containsKey(num))
                map.put(num, 1 + map.get(num));
            else map.put(num, 1);
        }
        for(int num : intArray) {
            if(map.get(num) > 1)
                return num;
        }
        throw new RuntimeException("Undefined behaviour");
    }

}
