class Solution {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        
        long long int l = 0, r = 2 * 1e9, mid;
        long long int ab = (a * b) / __gcd(a, b);
        long long int bc = (b * c) / __gcd(b, c);
        long long int ac = (a * c) / __gcd(a, c);
        long long int abc = (ab * c) / __gcd(ab, c);
        while (l < r) {
            mid = (l + r) / 2;
            long long int cnt = mid / a + mid / b + mid / c - mid / ab - mid / bc - mid / ac + mid / abc;
            if (cnt < n) l = mid + 1;
            else r = mid;
        }
        return l;
    }
};