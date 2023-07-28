class Solution {
public:
    int nthMagicalNumber(int n, int a, int b) {
        
        int MOD = 1000000007;
        int lcm = a * b / gcd(a, b);
        long lo = 0, hi = (long)1e15;
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            if (mi / a + mi / b - mi / lcm < n)
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo % MOD;
    }
};