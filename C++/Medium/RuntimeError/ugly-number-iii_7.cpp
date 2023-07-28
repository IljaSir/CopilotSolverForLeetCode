class Solution {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        
        long long int l = 1, r = 2 * 1e9, mid, ans = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            long long int cnt = mid / a + mid / b + mid / c - mid / lcm(a, b) - mid / lcm(a, c) - mid / lcm(b, c) + mid / lcm(a, lcm(b, c));
            if (cnt >= n) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans;
    }
    long long int gcd(long long int a, long long int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
};