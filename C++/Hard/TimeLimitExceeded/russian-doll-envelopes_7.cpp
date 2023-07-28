class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        
        if (envelopes.empty()) return 0;
        sort(envelopes.begin(), envelopes.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0] || (a[0] == b[0] && a[1] > b[1]);
        });
        vector<int> dp(envelopes.size(), 1);
        for (int i = 1; i < envelopes.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};