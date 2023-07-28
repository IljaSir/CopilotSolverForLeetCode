class Solution {
public:
    int visiblePoints(vector<vector<int>>& points, int angle, vector<int>& location) {
        
        int n = points.size();
        vector<double> angles;
        int same = 0;
        for (int i = 0; i < n; i++) {
            int x = points[i][0] - location[0];
            int y = points[i][1] - location[1];
            if (x == 0 && y == 0) {
                same++;
                continue;
            }
            angles.push_back(atan2(y, x) * 180 / M_PI);
        }
        sort(angles.begin(), angles.end());
        int m = angles.size();
        for (int i = 0; i < m; i++) {
            angles.push_back(angles[i] + 360);
        }
        int res = 0;
        int start = 0;
        for (int i = 0; i < m; i++) {
            while (angles[start] - angles[i] <= angle) {
                start++;
            }
            res = max(res, start - i);
        }
        return res + same;
    }
};