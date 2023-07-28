class Solution {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        
        long long ab = lcm(a, b);
        long long ac = lcm(a, c);
        long long bc = lcm(b, c);
        long long abc = lcm(ab, c);
        long long l = 1, r = 2 * 1e9;
        while (l < r) {
            long long m = l + (r - l) / 2;
            long long cnt = m / a + m / b + m / c - m / ab - m / ac - m / bc + m / abc;
            if (cnt >= n) r = m;
            else l = m + 1;
        }
        return l;
    }
};