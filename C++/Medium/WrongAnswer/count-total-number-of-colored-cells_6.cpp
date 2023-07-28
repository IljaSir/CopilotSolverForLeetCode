class Solution {
public:
    long long coloredCells(int n) {
        
        if (n == 1) return 1;
        long long ans = 0;
        for (int i = 1; i < n; ++i) {
            ans += 6LL * i;
        }
        return ans + 1;
    }
};