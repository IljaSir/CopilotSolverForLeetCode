class Solution {
public:
    vector<int> longestObstacleCourseAtEachPosition(vector<int>& obstacles) {
        
        int n = obstacles.size();
        vector<int> dp;
        vector<int> res(n);
        for (int i = 0; i < n; ++i) {
            int num = obstacles[i];
            auto it = lower_bound(dp.begin(), dp.end(), num);
            if (it == dp.end()) {
                dp.push_back(num);
                res[i] = dp.size();
            } else {
                *it = num;
                res[i] = it - dp.begin() + 1;
            }
        }
        return res;
    }
};