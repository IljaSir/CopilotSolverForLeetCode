class Solution {
public:
    long long mostPoints(vector<vector<int>>& questions) {
        
        vector<long long> dp(questions.size() + 1);
        sort(questions.begin(), questions.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] + a[0] > b[1] + b[0];
        });
        for (int i = 0; i < questions.size(); ++i) {
            dp[i + 1] = max(dp[i + 1], dp[i]);
            if (i + questions[i][1] + 1 <= questions.size()) {
                dp[i + questions[i][1] + 1] = max(dp[i + questions[i][1] + 1], dp[i] + questions[i][0]);
            }
        }
        return dp.back();
    }
};