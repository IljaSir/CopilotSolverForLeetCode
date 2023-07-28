class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        
        long sum = 0;
        long x = n;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        if (sum <= target) {
            return 0;
        }
        long y = 1;
        long ans = 0;
        while (sum > target) {
            long d = (n / y) % 10;
            if (d != 9) {
                ans += y * (10 - d);
                sum += 10 - d - d;
            }
            y *= 10;
        }
        return ans;
    }
}