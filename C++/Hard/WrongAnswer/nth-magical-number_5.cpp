class Solution {
public:
    int nthMagicalNumber(int n, int a, int b) {
        
        // a * b = gcd(a, b) * lcm(a, b)
        int mod = 1e9 + 7;
        int gcd = __gcd(a, b);
        int lcm = a * b / gcd;
        int k = lcm / a + lcm / b - 1;
        int q = n / k;
        int r = n % k;
        int ans = q * lcm % mod;
        int c = 0;
        for (int i = 1; i <= r; ++i) {
            if (i % a == 0 && i % b == 0) {
                c = i;
                break;
            }
        }
        ans = (ans + c) % mod;
        return ans;
    }
};