class Solution {
public:
    int visiblePoints(vector<vector<int>>& points, int angle, vector<int>& location) {
        
        int n = points.size();
        vector<double> angles;
        int extra = 0;
        for (auto &p : points) {
            if (p[0] == location[0] && p[1] == location[1]) {
                extra++;
            } else {
                angles.push_back(atan2(p[1] - location[1], p[0] - location[0]) * 180 / M_PI);
            }
        }
        sort(angles.begin(), angles.end());
        int m = angles.size();
        for (int i = 0; i < m; i++) {
            angles.push_back(angles[i] + 360);
        }
        int ans = 0;
        int i = 0;
        for (int j = 0; j < angles.size(); j++) {
            while (angles[j] - angles[i] > angle) {
                i++;
            }
            ans = max(ans, j - i + 1);
        }
        return ans + extra;
    }
};