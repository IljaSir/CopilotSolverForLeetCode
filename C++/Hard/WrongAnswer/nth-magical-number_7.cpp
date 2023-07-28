class Solution {
public:
    int nthMagicalNumber(int n, int a, int b) {
        
        int mod = 1000000007;
        int l = 2;
        int r = 1e9;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (mid / a + mid / b - mid / lcm(a, b) < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l % mod;
    }
    
    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
};