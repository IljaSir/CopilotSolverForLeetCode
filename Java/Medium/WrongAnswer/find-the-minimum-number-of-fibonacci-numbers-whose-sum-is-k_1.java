class Solution {
    public int findMinFibonacciNumbers(int k) {
        
        int[] fib = new int[40];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < 40; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        int ans = 0;
        for (int i = 39; i >= 0; i--) {
            if (k >= fib[i]) {
                k -= fib[i];
                ans++;
            }
        }
        return ans;
    }
}