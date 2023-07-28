class Solution {
public:
    int minimumScore(string s, string t) {
        
        int n = s.size(), m = t.size();
        vector<int> dp(n + 1, 0);
        for (int i = 0; i < m; ++i) {
            int pre = 0;
            for (int j = 0; j < n; ++j) {
                int temp = dp[j + 1];
                if (s[j] == t[i]) {
                    dp[j + 1] = max(dp[j + 1], pre + 1);
                }
                pre = max(pre, temp);
            }
        }
        return n - *max_element(dp.begin(), dp.end());
    }
};