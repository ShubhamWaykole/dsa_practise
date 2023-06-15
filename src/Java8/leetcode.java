package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class leetcode {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(11);
        q.add(12);
        q.add(23);
        q.add(7);
        q.add(12);
        q.add(3);
        while(!q.isEmpty())
            System.out.println(" " + q.remove());
        System.out.println("--------------------");
     //   int[] nums = {1,3,2,-2};
        longestPalindrome("babad");

        int target = 5;
   //     twoSum(nums,target);
        String[] strs = {"flower","flow","flight"};
        longestCommonPrefix(strs);
    }
    static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        List<List<Integer>> RetList = new ArrayList<>();
        while(left < right) {
            List<Integer> triplet = new ArrayList<>();
            int sum = nums[left] + nums[right];
            for (int i = 0; i < n; i++) {
                if (i != left && i != right && (nums[i] + sum) == 0) {
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    triplet.add(nums[i]);
                    RetList.add(triplet);
                    break;
                }
            }
            left++;
            right--;
        }
        return RetList;
    }
    static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];
        int strsLen = strs.length;
        StringBuilder sb = new StringBuilder();
        String res = "";
        int len = strs[0].length();
        char[] cArray = strs[0].toCharArray();
        for(int i=0; i< len; i++) {
            sb.append(cArray[i]);
            for(int j=1;j<strsLen ; j++){
                if(!sb.toString().equals(strs[j].substring(0,i+1)))
                    return res;
            }
            res = sb.toString();
        }
        return res;
    }
    static String longestPalindrome(String s) {
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        String ss = "";
        String large = "";
        for(int i=0; i<len - 1 ;i++) {
            for(int j=len; j>i; j--) {
                sb = new StringBuffer();
                ss = s.substring(i,j);
                sb.append(ss);
                if(sb.reverse().toString().equals(ss) && large.length() < ss.length())
                    large = ss;
            }
        }
        return large;
    }
    static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length; i++) {
            int n1 = nums[i];
            for(int j=0;j<nums.length; j++) {
                int n2 = nums[j];
                if(target == n1+n2)
                {
                    int[] ret = {i,j};
                    return ret;
                }
            }
        }
        int[] ret = {1,1};
        return ret;
    }
}
