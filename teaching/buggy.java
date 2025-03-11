public class Main {
    public static void main(String[] args) {
        factorial(10);
    }
    }

    static int factorial(int n) {
        var result = 1;

        while (n >= 0) {
            result *= n;
        }

        return result;
    }
