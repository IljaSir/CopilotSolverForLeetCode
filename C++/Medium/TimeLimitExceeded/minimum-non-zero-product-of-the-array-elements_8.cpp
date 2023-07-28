class Solution {
public:
    int minNonZeroProduct(int p) {
        
        long long n = (1LL << p) - 1;
        long long ans = (n - 1) % 1000000007;
        long long tmp = n - 2;
        long long base = (n - 1) % 1000000007;
        while (tmp) {
            if (tmp & 1) {
                ans = ans * base % 1000000007;
            }
            base = base * base % 1000000007;
            tmp >>= 1;
        }
        return ans;
    }
};