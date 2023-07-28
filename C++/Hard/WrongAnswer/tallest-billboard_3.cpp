class Solution {
public:
    int tallestBillboard(vector<int>& rods) {
        
        int n = rods.size();
        vector<int> dp(5001, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            vector<int> tmp(5001, -1);
            for (int j = 0; j <= 5000; j++) {
                if (dp[j] >= 0) {
                    tmp[j] = dp[j];
                    tmp[j + rods[i]] = max(tmp[j + rods[i]], dp[j]);
                    tmp[abs(j - rods[i])] = max(tmp[abs(j - rods[i])], dp[j] + min(j, rods[i]));
                }
            }
            dp = tmp;
        }
        return dp[0];
    }
};