class Solution {
public:
    int minNonZeroProduct(int p) {
        
        long long n = (1LL << p) - 1;
        long long m = (1LL << (p - 1)) - 1;
        long long ans = (n - 1) % 1000000007;
        ans = (ans * inv(n - m, 1000000007)) % 1000000007;
        return ans;
    }
};