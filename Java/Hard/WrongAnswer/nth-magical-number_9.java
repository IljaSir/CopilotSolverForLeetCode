class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        
        int mod = 1000000007;
        long res = 0;
        long l = 1, r = (long)n * Math.max(a, b);
        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = mid / a + mid / b - mid / (a * b);
            if (cnt < n) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;
            }
        }
        return (int)(res % mod);
    }
}