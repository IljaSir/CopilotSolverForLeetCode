class Solution {
public:
    vector<int> longestObstacleCourseAtEachPosition(vector<int>& obstacles) {
        
        int n = obstacles.size();
        vector<int> ans(n, 1);
        vector<int> dp;
        dp.push_back(obstacles[0]);
        for (int i = 1; i < n; ++i) {
            if (obstacles[i] >= dp.back()) {
                dp.push_back(obstacles[i]);
                ans[i] = dp.size();
            } else {
                auto it = lower_bound(dp.begin(), dp.end(), obstacles[i]);
                ans[i] = it - dp.begin() + 1;
                *it = obstacles[i];
            }
        }
        return ans;
    }
};