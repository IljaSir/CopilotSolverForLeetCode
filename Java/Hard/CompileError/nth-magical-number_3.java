class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        
        int mod = 1000000007;
        int lcm = a / gcd(a, b) * b;
        int lo = 0;
        int hi = Integer.MAX_VALUE;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid / a + mid / b - mid / lcm < n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo % mod;
    }
}