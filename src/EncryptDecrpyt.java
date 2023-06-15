public class EncryptDecrpyt {
    public static void main(String[] args) {
        char[][] input = {{'a', 'b', 'c'}, {' ', 'd', ' '}, {'e', 'f', 'g'}};
        int[][] encryptRes = encrypt(input);
        int rows = input.length;
        int columns = input[0].length;
        System.out.println("Original String is :");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Encrypted String is :");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(encryptRes[i][j] + " ");
            }
            System.out.println();
        }
        char[][] decryptRes = decrypt(encryptRes);
        System.out.println("Decrypted String is :");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(decryptRes[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] encrypt(char arr[][]) {
        if(arr.length == 0)
            return null;
        int rows = arr.length;
        int columns = arr[0].length;
        int[][] res = new int[rows][columns];
        for(int i=0;i<rows;i++)
            for(int j=0;j<columns;j++)
                res[i][j] = getIntVal(arr[i][j]);
        return res;
    }

    static char[][] decrypt(int arr[][]) {
        if(arr.length == 0)
            return null;
        int rows = arr.length;
        int columns = arr[0].length;
        char[][] res = new char[rows][columns];
        for(int i=0;i<rows;i++)
            for(int j=0;j<columns;j++)
                res[i][j] = getCharVal(arr[i][j]);
        return res;
    }

    static int getIntVal(char c) {
        if(c == ' ')
            return 0;
        return ((int) c) - 96;
    }

    static char getCharVal(int i) {
        if(i==0)
            return ' ';
        return ((char) (i+96));
    }
}
