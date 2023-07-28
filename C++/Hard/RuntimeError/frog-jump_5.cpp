class Solution {
public:
    bool canCross(vector<int>& stones) {
        
        int n = stones.size();
        if (n == 0) return false;
        if (n == 1) return true;
        if (stones[1] != 1) return false;
        vector<unordered_set<int>> dp(n);
        dp[1].insert(1);
        for (int i = 2; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                if (dp[j].find(k) != dp[j].end() || dp[j].find(k - 1) != dp[j].end() || dp[j].find(k + 1) != dp[j].end()) {
                    dp[i].insert(k);
                }
            }
        }
        return dp[n - 1].size() > 0;
    }
};