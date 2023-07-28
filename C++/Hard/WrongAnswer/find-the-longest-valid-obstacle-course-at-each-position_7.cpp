class Solution {
public:
    vector<int> longestObstacleCourseAtEachPosition(vector<int>& obstacles) {
        
        vector<int> ans;
        vector<int> dp;
        for (auto x: obstacles) {
            int i = lower_bound(dp.begin(), dp.end(), x) - dp.begin();
            if (i == dp.size()) {
                dp.push_back(x);
            } else {
                dp[i] = x;
            }
            ans.push_back(i + 1);
        }
        return ans;
    }
};