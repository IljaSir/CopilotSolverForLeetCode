class Solution {
public:
    int maximumInvitations(vector<int>& favorite) {
        
        int n = favorite.size();
        int res = 0;
        vector<int> dp(n, 1);
        for (int i = 0; i < n; ++i) {
            vector<bool> visited(n);
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = favorite[j];
            }
            if (j == i) {
                int len = 0;
                do {
                    visited[j] = false;
                    j = favorite[j];
                    ++len;
                } while (j != i);
                res += len;
                for (int k = 0; k < n; ++k) {
                    if (visited[k]) {
                        dp[k] = max(dp[k], len);
                    }
                }
            }
        }
        return res + *max_element(dp.begin(), dp.end());
    }
};