class Solution {
public:
    int tallestBillboard(vector<int>& rods) {
        
        int sum = 0;
        for (int i = 0; i < rods.size(); i++) {
            sum += rods[i];
        }
        int target = sum / 2;
        vector<int> dp(target + 1, -1);
        dp[0] = 0;
        for (int i = 0; i < rods.size(); i++) {
            for (int j = target; j >= rods[i]; j--) {
                if (dp[j - rods[i]] >= 0) {
                    dp[j] = max(dp[j], dp[j - rods[i]] + rods[i]);
                }
            }
        }
        return dp[target];
    }
};