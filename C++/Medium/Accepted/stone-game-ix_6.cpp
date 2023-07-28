class Solution {
public:
    bool stoneGameIX(vector<int>& stones) {
        
        int dp[3] = {0};
        for (auto stone : stones) {
            dp[stone % 3]++;
        }
        if (dp[0] % 2 == 0) {
            return dp[1] > 0 && dp[2] > 0;
        } else {
            return abs(dp[1] - dp[2]) >= 3;
        }
    }
};