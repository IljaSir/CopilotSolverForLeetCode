class Solution {
public:
    int shortestSequence(vector<int>& rolls, int k) {
        
        int n = rolls.size();
        int dp[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            int j = i - k;
            if (j >= 0 && rolls[i-1] == rolls[j]) {
                dp[i] = min(dp[i], dp[j] + 1);
            }
        }
        return dp[n];
    }
};