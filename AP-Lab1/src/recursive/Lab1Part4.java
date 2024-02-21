package recursive;

public class Lab1Part4 {
    public static void main(String[] args) {
        int sum = recursiveSum(3);
        System.out.println(sum);

        String alphabet = buildAlphabetString('c');
        System.out.println(alphabet);
    }

    /**
     * Sums all numbers from num to 0
     * @param num
     * @return int
     */
    public static int recursiveSum(int num) {
        if (num>0) {
            return num+recursiveSum(num-1);
        } else
            return 0;
    }

    /**
     * returns alphabet from input letter to 'z'
     * @param letter
     * @return String
     */
    public static String buildAlphabetString(char letter) {
        if (letter<122) {
            return letter+buildAlphabetString((char)(letter+1));
        } else
            return "";
    }
}
