class Solution {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        
        int l = 1, r = 2e9;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid, a, b, c) >= n) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    long long check(int mid, int a, int b, int c) {
        return mid / a + mid / b + mid / c - mid / lcm(a, b) - mid / lcm(a, c) - mid / lcm(b, c) + mid / lcm(a, lcm(b, c));
    }
    long long gcd(long long a, long long b) {
        return b ? gcd(b, a % b) : a;
    }
};