public class Main {
    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    static int factorial(int n) {
        var result = 1;

        while (n > 0) {
            result *= n;
            n -= 1;
        }

        return result;
    }
}
