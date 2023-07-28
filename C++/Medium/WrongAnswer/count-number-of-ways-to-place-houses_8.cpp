class Solution {
public:
    int countHousePlacements(int n) {
        
        int MOD = 1e9 + 7;
        int a = 1, b = 1;
        for (int i = 1; i <= n; ++i) {
            int c = (long long)(a + b) * (a + b) % MOD;
            a = b;
            b = c;
        }
        return b;
    }
};