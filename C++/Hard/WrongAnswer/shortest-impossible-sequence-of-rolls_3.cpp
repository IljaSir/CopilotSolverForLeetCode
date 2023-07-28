class Solution {
public:
    int shortestSequence(vector<int>& rolls, int k) {
        
        int n = rolls.size();
        vector<int> dp(n + 1);
        vector<int> last(k + 1);
        int res = n + 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;
            if (i >= k) {
                dp[i] = min(dp[i], dp[last[rolls[i - k]]] + 1);
            }
            last[rolls[i - 1]] = i;
            if (i >= k) {
                res = min(res, dp[i] - dp[i - k]);
            }
        }
        return res == n + 1 ? -1 : res;
    }
};