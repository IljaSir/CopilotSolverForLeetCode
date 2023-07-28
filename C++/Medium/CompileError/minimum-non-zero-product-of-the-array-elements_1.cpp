class Solution {
public:
    int minNonZeroProduct(int p) {
        
        long long ans = 1;
        for (int i = 1; i < p; ++i) {
            ans = ans * 2 % 1000000007;
        }
        return (ans - 1) * pow(ans - 2, (1 << p) - 2) % 1000000007;
    }
};