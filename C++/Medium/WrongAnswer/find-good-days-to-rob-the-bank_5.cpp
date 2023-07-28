class Solution {
public:
    vector<int> goodDaysToRobBank(vector<int>& security, int time) {
        
        vector<int> res;
        int n = security.size();
        vector<int> dp(n, 0);
        for (int i = 0; i < n; i++) {
            if (i - time - 1 >= 0) {
                dp[i] = max(dp[i], dp[i - time - 1]);
            }
            dp[i] = max(dp[i], security[i]);
            if (i + time < n) {
                dp[i + time] = max(dp[i + time], dp[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (security[i] == dp[i]) {
                res.push_back(i);
            }
        }
        return res;
    }
};