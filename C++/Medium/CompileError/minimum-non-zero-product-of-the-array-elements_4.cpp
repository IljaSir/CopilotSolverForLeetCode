class Solution {
public:
    int minNonZeroProduct(int p) {
        
        long long n = (1LL << p) - 1;
        long long m = (1LL << (p - 1)) - 1;
        return (n * pow(n - 1, m, 1000000007)) % 1000000007;
    }
};