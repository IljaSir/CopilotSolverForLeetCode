class Solution {
public:
    int maxHappyGroups(int batchSize, vector<int>& groups) {
        
        int n = groups.size();
        vector<int> dp(batchSize, 0);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int x = groups[i] % batchSize;
            if (x == 0) ans++;
            else {
                dp[x]++;
            }
        }
        for (int i = 1; i < batchSize; ++i) {
            int j = batchSize - i;
            if (i > j) break;
            if (i == j) {
                ans += dp[i] / 2;
            } else {
                ans += min(dp[i], dp[j]);
            }
        }
        return ans;
    }
};