class Solution {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        
        int l = 1, r = 2e9;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (cnt(m, a, b, c) < n) l = m + 1;
            else r = m;
        }
        return l;
    }
    
    long long cnt(int m, int a, int b, int c) {
        return m / a + m / b + m / c - m / lcm(a, b) - m / lcm(a, c) - m / lcm(b, c) + m / lcm(lcm(a, b), c);
    }
};