public class App {

    public static void main(String[] args) throws Exception {
        //runFibonaci();
        runFibonaciRecPD();
        

    }
    private static void runFibonaci() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacci(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = executionTime / 1_000_000.0;

        System.out.println("Finbonaci de " + num + " es " + i + " en: " + milliseconds + " milliseconds");
    }

    private static long getFibonacci(int i) {
        if (i <= 1) {
            return i;
        }
        return getFibonacci(i - 1) + getFibonacci(i - 2);
    }

    private static void runFibonaciRecPD() {
        long startTime = System.nanoTime();
        int num = 48;

        long[] cache = new long[num + 1];
        long i = getFibonacciPD(num, cache);

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = executionTime / 1_000_000.0;

        System.out.println("Finbonaci de " + num + " es " + i + " en: " + milliseconds + " milliseconds");
    }

    private static long getFibonacciPD(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = getFibonacciPD(n - 1, memo) + getFibonacciPD(n - 2, memo);

        return memo[n];
    }

    public static long fibonacci(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }

    //private static long getFibonacciIter(int num) {
      //  if(num <= 1) return num;
       // long[] memo = new long[num + 1];
        //memo[0] = 0; 
        //memo[1] = 1; 
        //for(int i = 2; i <= num; i++){
          //  memo[i] = memo[i -1] + memo[i-2];

        //}
        //return memo[num];
    //}
    //0(1)
        private static long getFibonacciIter(int num) {
        if(num <= 1) return num;
        long a = 0;
        long b = 1;
        long res = 0;  

        for(int i = 2; i <= num; i++){
            res = a + b;
            a = b;

        }
        return res;
    }
}