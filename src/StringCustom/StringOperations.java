package StringCustom;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class StringOperations {
    public static void main(String args[]) {
        StringBuffer sb = new StringBuffer();
        romanToInt("MCMXCIV");
        String str = "abaacdbqeqgg";
        String str2 = "ggabaeqacdbq";
        String str3 = "ggabaeqacdba";
        System.out.println("Original String is : " + str);
        removeDuplicatesAndPrint(str);

        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");

        System.out.println("original string: " + str);
        System.out.println("reversed string: " + reverse(str));

        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");

        System.out.println("original string: " + str);
        System.out.print("duplicates in string: ");
        printDuplicates(str);

        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");

        System.out.println("string 1 is " + str);
        System.out.println("string 2 is " + str2);
        if(checkAnagramWithoutSort(str, str2) )
            System.out.println("String 1 and 2 are anagrams");
        else
            System.out.println("String 1 and 2 are not anagrams");

        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");

        System.out.println("string 1 is " + str2);
        System.out.println("string 2 is " + str3);
        if(checkAnagramWithoutSort(str2, str3) )
            System.out.println("String 1 and 2 are anagrams");
        else
            System.out.println("String 1 and 2 are not anagrams");

        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");

        System.out.println("original string: " + "abc");
        System.out.println("Recursively reversed string: " + reverseRecursively("abc"));


        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");

        System.out.println("String is: " + "abcdefgh");
        System.out.println("Query String is : " + "abhg");
        System.out.println("IsSubseruqnce : " + isSubsequence("abcdefgh","abhg"));

    }

    public static boolean isSubsequence(String s, String q) {
        int i=0, j=0;
        int len = s.length();
        int len1 = q.length();
        char[] s1 = s.toCharArray();
        char[] q1= q.toCharArray();
        if(s.equals(q)) {}
        while(i < len) {
            if(s1[i] == q1[j]) {
                j++;
            }
            i++;
            if(j==len1)
                return true;
        }

        return false;

    }
    public static String reverseRecursively(String str) {
        //base case to handle one char string and empty string
      if(str.length() < 2)
          return str;
      return reverseRecursively(str.substring(1)) + str.charAt(0);
    }

    static boolean checkAnagramWithoutSort(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            char ch1 = charArray1[i];
            char ch2 = charArray2[i];
            if(map1.containsKey(ch1))
                map1.put(ch1, map1.get(ch1) +1);
            else
                map1.put(ch1,1);
            if(map2.containsKey(ch2))
                map2.put(ch2, map2.get(ch2) +1);
            else
                map2.put(ch2,1);
        }
        return map1.equals(map2);
    }

    static void printDuplicates(String str) {
        HashSet<Character> charSet = new HashSet<Character>();
        char[] charArray = str.toCharArray();
        for(char ch : charArray) {
            if (!charSet.contains(ch))
                charSet.add(ch);
            else
                System.out.print(ch + " ");
        }
        System.out.println();
    }
    static String reverse(String str) {
        char[] chars = str.toCharArray();
        int len = str.length();
        for(int i=0; i<len/2; i++) {
            char temp = chars[i];
            chars[i] = chars[len- i - 1];
            chars[len - 1- i] = temp;
        }
        return String.valueOf(chars) ;
    }
    static void removeDuplicatesAndPrint(String str) {
        char[] charArray = str.toCharArray();
        System.out.println("Array with duplicates : " + Arrays.toString(charArray));
        LinkedHashSet<Character> set = new LinkedHashSet<Character>();
        for(char ch : charArray)
            set.add(ch);
        System.out.print("Array wout duplicates : ");
        set.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }

    static int romanToInt(String s) {
        int sum = 0;
        char prev = s.charAt(0);
        for(char c: s.toCharArray()) {
            if(prev == 'I') {
                if(c == 'V') {
                    sum -= 1;
                    sum += 4;
                    continue;
                }
                if(c == 'X') {
                    sum -= 1;
                    sum += 10;
                    continue;
                }
            }
            if(prev == 'X') {
                if(c == 'L') {
                    sum -= 10;
                    sum += 40;
                    continue;
                }
                if(c == 'C') {
                    sum -= 10;
                    sum += 90;
                    continue;
                }
            }
            if(prev == 'C') {
                if(c == 'D') {
                    sum -= 100;
                    sum += 400;
                    continue;
                }
                if(c == 'M') {
                    sum -= 100;
                    sum += 900;
                    continue;
                }
            }
            switch(c) {
                case 'I': ; sum += 1; break;
                case 'V': ; sum += 5; break;
                case 'X': ; sum += 10; break;
                case 'L': ; sum += 50; break;
                case 'C': ; sum += 100; break;
                case 'D': ; sum += 500; break;
                case 'M': ; sum += 1000; break;
            }
            prev = c;
        }
        return sum;
    }
}
