class Solution {
public:
    vector<int> longestObstacleCourseAtEachPosition(vector<int>& obstacles) {
        
        int n = obstacles.size();
        vector<int> ans(n, 1);
        vector<int> dp;
        for (int i = 0; i < n; ++i) {
            int x = obstacles[i];
            auto it = lower_bound(dp.begin(), dp.end(), x);
            if (it == dp.end()) {
                dp.push_back(x);
                ans[i] = dp.size();
            } else {
                *it = x;
                ans[i] = it - dp.begin() + 1;
            }
        }
        return ans;
    }
};