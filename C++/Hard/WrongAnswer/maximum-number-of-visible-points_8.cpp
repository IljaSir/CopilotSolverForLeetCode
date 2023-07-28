class Solution {
public:
    int visiblePoints(vector<vector<int>>& points, int angle, vector<int>& location) {
        
        int n = points.size();
        vector<double> angles(n);
        int extra = 0;
        for (int i = 0; i < n; ++i) {
            if (points[i][0] == location[0] && points[i][1] == location[1]) {
                ++extra;
                continue;
            }
            angles[i] = atan2(points[i][1] - location[1], points[i][0] - location[0]) * 180 / M_PI;
            if (angles[i] < 0) angles[i] += 360;
        }
        sort(angles.begin(), angles.end());
        int ans = 1;
        int i = 0, j = 0;
        while (i < n) {
            while (j < n && angles[j] - angles[i] <= angle) ++j;
            ans = max(ans, j - i);
            ++i;
        }
        return ans + extra;
    }
};