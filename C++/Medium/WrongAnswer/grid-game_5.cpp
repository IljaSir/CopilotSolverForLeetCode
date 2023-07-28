class Solution {
public:
    long long gridGame(vector<vector<int>>& grid) {
        
        int n = grid[0].size();
        vector<long long> pre(n+1);
        vector<long long> suf(n+1);
        for (int i = 0; i < n; ++i) {
            pre[i+1] = pre[i] + grid[0][i];
        }
        for (int i = n-1; i >= 0; --i) {
            suf[i] = suf[i+1] + grid[1][i];
        }
        long long ans = 1e18;
        for (int i = 0; i < n; ++i) {
            ans = min(ans, max(pre[i], suf[i+1]));
        }
        return ans;
    }
};