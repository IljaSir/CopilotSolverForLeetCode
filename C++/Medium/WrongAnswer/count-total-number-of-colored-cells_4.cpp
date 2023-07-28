class Solution {
public:
    long long coloredCells(int n) {
        
        long long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += (n - i + 1) * 2;
        }
        return ans;
    }
};