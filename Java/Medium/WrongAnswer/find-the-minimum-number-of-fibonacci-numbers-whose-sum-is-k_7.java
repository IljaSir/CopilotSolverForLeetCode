class Solution {
    public int findMinFibonacciNumbers(int k) {
        
        int count = 0;
        int a = 1;
        int b = 1;
        int c = 0;
        while (c < k) {
            c = a + b;
            a = b;
            b = c;
        }
        while (k > 0) {
            if (k >= a) {
                k -= a;
                count++;
            }
            c = a;
            a = b - a;
            b = c;
        }
        return count;
    }
}