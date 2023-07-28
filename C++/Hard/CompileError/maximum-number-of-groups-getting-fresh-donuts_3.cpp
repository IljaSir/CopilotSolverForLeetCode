class Solution {
public:
    int maxHappyGroups(int batchSize, vector<int>& groups) {
        
        int n = groups.size();
        vector<int> cnt(batchSize, 0);
        for (int g : groups) {
            cnt[g % batchSize]++;
        }
        vector<vector<int>> dp(batchSize, vector<int>(1 << n, -1));
        return cnt[0] + dfs(cnt, dp, 0, 0, n, batchSize);
    }
    
    int dfs(vector<int>& cnt, vector<vector<int>>& dp, int mask, int mod, int n, int batchSize) {
        if (mask == (1 << n) - 1) {
            return 0;
        }
        if (dp[mod][mask] != -1) {
            return dp[mod][mask];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (mask & (1 << i) || cnt[(mod + groups[i]) % batchSize] == 0) {
                continue;
            }
            cnt[(mod + groups[i]) % batchSize]--;
            res = max(res, dfs(cnt, dp, mask | (1 << i), (mod + groups[i]) % batchSize, n, batchSize) + ((mod + groups[i]) % batchSize == 0));
            cnt[(mod + groups[i]) % batchSize]++;
        }
        return dp[mod][mask] = res;
    }
};