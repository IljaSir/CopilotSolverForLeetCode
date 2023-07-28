class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        
        long ab = lcm(a, b), ac = lcm(a, c), bc = lcm(b, c), abc = lcm(a, bc);
        int lo = 1, hi = 2 * (int)1e9;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
            if (count < n) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}