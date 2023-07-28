class Solution {
    public int findMinFibonacciNumbers(int k) {
        
        int[] fib = new int[100];
        fib[0] = 1;
        fib[1] = 1;
        int i = 2;
        while (fib[i - 1] + fib[i - 2] <= k) {
            fib[i] = fib[i - 1] + fib[i - 2];
            i++;
        }
        int count = 0;
        while (k > 0) {
            int t = i - 1;
            while (t >= 0 && fib[t] > k) {
                t--;
            }
            k -= fib[t];
            count++;
        }
        return count;
    }
}