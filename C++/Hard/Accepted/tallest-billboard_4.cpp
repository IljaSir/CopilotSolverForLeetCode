class Solution {
public:
    int tallestBillboard(vector<int>& rods) {
        
        int sum = 0;
        for (auto rod : rods) sum += rod;
        vector<int> dp(sum + 1, -1);
        dp[0] = 0;
        for (auto rod : rods) {
            vector<int> dp2 = dp;
            for (int i = 0; i <= sum - rod; i++) {
                if (dp[i] >= 0) {
                    dp2[i + rod] = max(dp2[i + rod], dp[i]);
                    dp2[abs(i - rod)] = max(dp2[abs(i - rod)], dp[i] + min(i, rod));
                }
            }
            dp = dp2;
        }
        return dp[0];
    }
};