class Solution {
public:
    int nthMagicalNumber(int n, int a, int b) {
        
        int MOD = 1e9 + 7;
        long long lcm = a * (long long)b / __gcd(a, b);
        long long lo = 1, hi = 1e15, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (mid / a + mid / b - mid / lcm < n) lo = mid + 1;
            else hi = mid;
        }
        return lo % MOD;
    }
};