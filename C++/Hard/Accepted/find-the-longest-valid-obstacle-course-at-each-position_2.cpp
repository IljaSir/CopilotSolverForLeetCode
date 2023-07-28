class Solution {
public:
    vector<int> longestObstacleCourseAtEachPosition(vector<int>& obstacles) {
        
        int n = obstacles.size();
        vector<int> res(n, 0);
        vector<int> dp = {obstacles[0]};
        res[0] = 1;
        for (int i = 1; i < n; ++i) {
            if (obstacles[i] >= dp.back()) {
                dp.push_back(obstacles[i]);
                res[i] = dp.size();
            } else {
                int pos = upper_bound(dp.begin(), dp.end(), obstacles[i]) - dp.begin();
                dp[pos] = obstacles[i];
                res[i] = pos + 1;
            }
        }
        return res;
    }
};