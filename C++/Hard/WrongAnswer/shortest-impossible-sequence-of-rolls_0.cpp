class Solution {
public:
    int shortestSequence(vector<int>& rolls, int k) {
        
        int n = rolls.size();
        vector<int> dp(n + 1, n + 1);
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            int minv = n + 1;
            for (int j = i; j >= max(0, i - k + 1); --j) {
                minv = min(minv, rolls[j]);
                dp[i + 1] = min(dp[i + 1], dp[j] + minv);
            }
        }
        return dp[n];
    }
};