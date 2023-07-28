class Solution {
public:
    int visiblePoints(vector<vector<int>>& points, int angle, vector<int>& location) {
        
        int count = 0;
        vector<double> angles;
        for (auto &p: points) {
            if (p[0] == location[0] && p[1] == location[1]) {
                count++;
            } else {
                angles.push_back(atan2(p[1] - location[1], p[0] - location[0]) * 180 / M_PI);
            }
        }
        sort(angles.begin(), angles.end());
        int n = angles.size();
        for (int i = 0; i < n; i++) {
            angles.push_back(angles[i] + 360);
        }
        int i = 0, j = 0, res = 0;
        while (j < angles.size()) {
            if (angles[j] - angles[i] <= angle) {
                res = max(res, j - i + 1);
                j++;
            } else {
                i++;
            }
        }
        return res + count;
    }
};