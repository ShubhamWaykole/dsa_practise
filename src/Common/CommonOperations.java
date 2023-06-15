package Common;

public class CommonOperations {
    static int n1,n2;
    public static void main(String[] args) {
        n1 = 3;
        n2 = 2;
        System.out.println("Value of a is :" + n1);
        System.out.println("Value of b is :" + n2);
        swap();
        System.out.println("----Swapping-----");
        System.out.println("Value of a is :" + n1);
        System.out.println("Value of b is :" + n2);
    }

    static void swap() {
        n1 = n1 + n2;
        n2 = n1 - n2;
        n1 = n1 - n2;
    }
}
