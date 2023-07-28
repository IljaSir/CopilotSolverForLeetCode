class Solution {
public:
    string stoneGameIII(vector<int>& stoneValue) {
        
        int n = stoneValue.size();
        vector<int> dp(n, 0);
        dp[n - 1] = stoneValue[n - 1];
        int sum = stoneValue[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            sum += stoneValue[i];
            dp[i] = sum - dp[i + 1];
            if (i + 2 < n) {
                dp[i] = max(dp[i], sum - dp[i + 2]);
            }
            if (i + 3 < n) {
                dp[i] = max(dp[i], sum - dp[i + 3]);
            }
        }
        if (dp[0] * 2 == sum) {
            return "Tie";
        } else if (dp[0] * 2 > sum) {
            return "Alice";
        } else {
            return "Bob";
        }
    }
};