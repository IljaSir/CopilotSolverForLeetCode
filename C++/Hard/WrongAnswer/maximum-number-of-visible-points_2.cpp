class Solution {
public:
    int visiblePoints(vector<vector<int>>& points, int angle, vector<int>& location) {
        
        vector<double> angles;
        int samePoints = 0;
        for (auto p : points) {
            if (p[0] == location[0] && p[1] == location[1]) {
                samePoints++;
                continue;
            }
            double a = atan2(p[1] - location[1], p[0] - location[0]) * 180 / M_PI;
            angles.push_back(a);
            angles.push_back(a + 360);
        }
        sort(angles.begin(), angles.end());
        int i = 0, j = 0, n = angles.size(), res = samePoints;
        while (j < n) {
            while (j < n && angles[j] - angles[i] <= angle) {
                res = max(res, j - i + 1);
                j++;
            }
            i++;
        }
        return res;
    }
};