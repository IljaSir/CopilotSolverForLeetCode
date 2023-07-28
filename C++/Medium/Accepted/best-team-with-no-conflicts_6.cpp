class Solution {
public:
    int bestTeamScore(vector<int>& scores, vector<int>& ages) {
        
        int n = scores.size();
        vector<vector<int>> v(n);
        for (int i = 0; i < n; i++) {
            v[i] = {ages[i], scores[i]};
        }
        sort(v.begin(), v.end());
        vector<int> dp(n);
        for (int i = 0; i < n; i++) {
            dp[i] = v[i][1];
            for (int j = 0; j < i; j++) {
                if (v[i][1] >= v[j][1]) {
                    dp[i] = max(dp[i], dp[j] + v[i][1]);
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};