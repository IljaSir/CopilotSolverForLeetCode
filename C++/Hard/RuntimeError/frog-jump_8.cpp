class Solution {
public:
    bool canCross(vector<int>& stones) {
        
        if (stones.empty()) return true;
        if (stones[0] != 0) return false;
        int n = stones.size();
        if (n == 1) return true;
        if (stones[1] != 1) return false;
        unordered_map<int, unordered_set<int>> dp;
        dp[0].insert(0);
        dp[1].insert(1);
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int diff = stones[i] - stones[j];
                if (dp[j].find(diff - 1) != dp[j].end() || dp[j].find(diff) != dp[j].end() || dp[j].find(diff + 1) != dp[j].end()) {
                    dp[i].insert(diff);
                }
            }
        }
        return !dp[n - 1].empty();
    }
};