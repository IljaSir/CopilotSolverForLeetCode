class Solution {
public:
    int nthMagicalNumber(int n, int a, int b) {
        
        int mod = 1e9 + 7;
        int l = 0, r = 1e15;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid / a + mid / b - mid / (a * b / __gcd(a, b)) < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l % mod;
    }
};