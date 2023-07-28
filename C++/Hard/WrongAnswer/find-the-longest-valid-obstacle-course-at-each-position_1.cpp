class Solution {
public:
    vector<int> longestObstacleCourseAtEachPosition(vector<int>& obstacles) {
        
        vector<int> dp;
        vector<int> ans;
        for (int i = 0; i < obstacles.size(); ++i) {
            auto it = lower_bound(dp.begin(), dp.end(), obstacles[i]);
            if (it == dp.end()) {
                dp.push_back(obstacles[i]);
            } else {
                *it = obstacles[i];
            }
            ans.push_back(dp.size());
        }
        return ans;
    }
};