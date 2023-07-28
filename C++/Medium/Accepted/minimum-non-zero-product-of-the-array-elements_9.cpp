class Solution {
public:
    int minNonZeroProduct(int p) {
        
        long long ans = 1;
        long long n = (1LL << p);
        long long m = (1LL << (p - 1)) - 1;
        ans = (n - 1) % 1000000007;
        ans = (ans * power(n - 2, m)) % 1000000007;
        return (int)ans;
    }
    long long power(long long x, long long y) {
        long long res = 1;
        x = x % 1000000007;
        while (y > 0) {
            if (y & 1)
                res = (res * x) % 1000000007;
            y = y >> 1;
            x = (x * x) % 1000000007;
        }
        return res;
    }
};