class Solution {
public:
    int minNonZeroProduct(int p) {
        
        long long n = (1LL << p) - 1;
        long long m = (1LL << (p - 1)) - 1;
        long long res = (n - 1) % 1000000007;
        long long base = n - 1;
        while (m) {
            if (m & 1) res = res * base % 1000000007;
            base = base * base % 1000000007;
            m >>= 1;
        }
        return res;
    }
};