class Solution {
    public int findMinFibonacciNumbers(int k) {
        
        int[] fib = new int[50];
        fib[1] = 1;
        int i = 2;
        while (fib[i - 1] + fib[i - 2] <= k) {
            fib[i] = fib[i - 1] + fib[i - 2];
            i++;
        }
        int ans = 0;
        for (int j = i; j >= 1; j--) {
            if (k >= fib[j]) {
                k -= fib[j];
                ans++;
            }
        }
        return ans;
    }
}