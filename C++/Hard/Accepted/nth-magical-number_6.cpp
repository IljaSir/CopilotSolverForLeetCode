class Solution {
public:
    int nthMagicalNumber(int n, int a, int b) {
        
        long long int l = 1, r = 1e15;
        long long int c = a * b / __gcd(a, b);
        while (l < r) {
            long long int m = l + (r - l) / 2;
            if (m / a + m / b - m / c < n) l = m + 1;
            else r = m;
        }
        return l % (int) (1e9 + 7);
    }
};