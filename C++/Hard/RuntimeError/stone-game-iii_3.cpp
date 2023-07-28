class Solution {
public:
    string stoneGameIII(vector<int>& stoneValue) {
        
        int n = stoneValue.size();
        vector<int> dp(n, 0);
        dp[n-1] = stoneValue[n-1];
        for (int i = n-2; i >= 0; i--) {
            int sum = 0;
            dp[i] = INT_MIN;
            for (int j = i; j < i+3 && j < n; j++) {
                sum += stoneValue[j];
                dp[i] = max(dp[i], sum - dp[j+1]);
            }
        }
        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }
};