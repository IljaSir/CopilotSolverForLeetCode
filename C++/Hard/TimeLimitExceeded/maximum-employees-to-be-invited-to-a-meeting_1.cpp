class Solution {
public:
    int maximumInvitations(vector<int>& favorite) {
        
        int n = favorite.size();
        vector<int> next(n, -1);
        for (int i = 0; i < n; ++i) {
            int j = i;
            while (next[j] == -1) {
                j = favorite[j];
            }
            int k = j;
            while (next[j] == -1) {
                next[j] = k;
                j = favorite[j];
            }
        }
        vector<int> dp(n);
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (next[i] == i) {
                dp[i] = 1;
            } else if (next[i] > i) {
                dp[i] = dp[next[i]] + 1;
            } else {
                dp[i] = dp[next[i]];
            }
            res = max(res, dp[i]);
        }
        return res;
    }
};