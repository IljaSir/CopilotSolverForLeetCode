class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        
        long sum = 0;
        long x = 1;
        while (n > 0) {
            long d = n % 10;
            sum += d;
            n /= 10;
            if (sum > target) {
                sum -= d;
                n += 1;
                x = 1;
            } else {
                x *= 10;
            }
        }
        return x - 1;
    }
}