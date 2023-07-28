class Solution {
public:
    int minNonZeroProduct(int p) {
        
        long long n = 1LL << p;
        long long res = (n - 1) * (n / 2) % 1000000007;
        return res;
    }
};