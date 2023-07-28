class Solution {
public:
    int visiblePoints(vector<vector<int>>& points, int angle, vector<int>& location) {
        
        int count = 0;
        vector<double> angles;
        for (auto point : points) {
            if (point[0] == location[0] && point[1] == location[1]) {
                count++;
            } else {
                angles.push_back(atan2(point[1] - location[1], point[0] - location[0]) * 180 / M_PI);
            }
        }
        sort(angles.begin(), angles.end());
        int n = angles.size();
        for (int i = 0; i < n; i++) {
            angles.push_back(angles[i] + 360);
        }
        int res = 0;
        int l = 0;
        for (int r = 0; r < angles.size(); r++) {
            while (angles[r] - angles[l] > angle) {
                l++;
            }
            res = max(res, r - l + 1);
        }
        return res + count;
    }
};