class Solution {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        
        long long l = 1, r = 2e9;
        while (l < r) {
            long long mid = l + r >> 1;
            if (mid / a + mid / b + mid / c - mid / lcm(a, b) - mid / lcm(a, c) - mid / lcm(b, c) + mid / lcm(lcm(a, b), c) < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    int gcd(int a, int b) {
        return b ? gcd(b, a % b) : a;
    }
};