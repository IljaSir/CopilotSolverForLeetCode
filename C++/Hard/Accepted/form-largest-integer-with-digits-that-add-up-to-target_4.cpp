class Solution {
public:
    string largestNumber(vector<int>& cost, int target) {
        
        vector<int> dp(target + 1, INT_MIN);
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < 9; j++) {
                if (i >= cost[j]) {
                    dp[i] = max(dp[i], dp[i - cost[j]] + 1);
                }
            }
        }
        if (dp[target] < 0) {
            return "0";
        }
        string ans;
        for (int i = 8, j = target; i >= 0; i--) {
            int costi = cost[i];
            while (j >= costi && dp[j] == dp[j - costi] + 1) {
                ans += to_string(i + 1);
                j -= costi;
            }
        }
        return ans;
    }
};