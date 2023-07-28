class Solution {
public:
    int nthMagicalNumber(int n, int a, int b) {
        
        int l = 0, r = 1e15;
        int mod = 1e9+7;
        long long ab = a * b / __gcd(a, b);
        while (l < r) {
            int m = l + (r - l) / 2;
            int cnt = m / a + m / b - m / ab;
            if (cnt < n) l = m + 1;
            else r = m;
        }
        return l % mod;
    }
};