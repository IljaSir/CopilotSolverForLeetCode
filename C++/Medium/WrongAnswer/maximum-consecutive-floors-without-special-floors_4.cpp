class Solution {
public:
    int maxConsecutive(int bottom, int top, vector<int>& special) {
        
        int n = special.size();
        vector<int> dp(n+1, 0);
        for (int i = 0; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && special[j] == special[j+1] - 1) j--;
            dp[i+1] = max(dp[i+1], dp[j+1] + 1);
            dp[i+1] = max(dp[i+1], special[i] - bottom + 1);
            if (i < n-1) dp[i+1] = max(dp[i+1], special[i+1] - special[i] - 1);
            else dp[i+1] = max(dp[i+1], top - special[i]);
        }
        return dp[n];
    }
};