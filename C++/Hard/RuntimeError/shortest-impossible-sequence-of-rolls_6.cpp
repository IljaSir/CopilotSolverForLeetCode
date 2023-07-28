class Solution {
public:
    int shortestSequence(vector<int>& rolls, int k) {
        
        int n = rolls.size();
        vector<int> dp(n, INT_MAX);
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int j = i - k + 1;
            if (j >= 0) {
                dp[i] = min(dp[i], dp[j] + 1);
            }
            for (int j = i + 1; j < n && rolls[j] == rolls[i]; j++) {
                dp[j] = dp[i];
            }
        }
        return dp[n - 1];
    }
};