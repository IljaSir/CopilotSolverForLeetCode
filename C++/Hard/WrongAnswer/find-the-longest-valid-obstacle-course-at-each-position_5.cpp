class Solution {
public:
    vector<int> longestObstacleCourseAtEachPosition(vector<int>& obstacles) {
        
        vector<int> res;
        for (int i = 0; i < obstacles.size(); ++i) {
            int left = 0, right = res.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (res[mid] <= obstacles[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == res.size()) {
                res.push_back(obstacles[i]);
            } else {
                res[left] = obstacles[i];
            }
        }
        return vector<int>(res.size(), 1);
    }
};