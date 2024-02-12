public class IntegerOverflow {
    public static void main(String[] args) {
        int a = 2147483647;
        int b = 1;

        int sum = a + b;

        if (a > 0 && b > 0 && sum < 0) {
            System.out.println("Overflow");

            long longSum = (long) a + b;

            System.out.println(longSum);
            return;
        }
        
        System.out.println(sum);
    }
}
