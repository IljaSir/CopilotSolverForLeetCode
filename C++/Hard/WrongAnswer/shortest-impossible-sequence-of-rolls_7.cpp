class Solution {
public:
    int shortestSequence(vector<int>& rolls, int k) {
        
        int n = rolls.size();
        vector<int> dp(1+n, 0);
        vector<int> cnt(k+1, 0);
        for (int i = 0; i < n; i++) {
            cnt[rolls[i]]++;
            dp[i+1] = dp[i] + 1;
            if (i >= k) {
                cnt[rolls[i-k]]--;
            }
            int j = 0;
            for (j = 1; j <= k; j++) {
                if (cnt[j] == 0) {
                    break;
                }
            }
            if (j > k) {
                dp[i+1] = min(dp[i+1], dp[i-k+1] + 1);
            }
        }
        return dp[n];
    }
};