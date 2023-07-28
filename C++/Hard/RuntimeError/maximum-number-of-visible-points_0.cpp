class Solution {
public:
    int visiblePoints(vector<vector<int>>& points, int angle, vector<int>& location) {
        
        vector<double> angles;
        int origin = 0;
        for (auto& p : points) {
            if (p[0] == location[0] && p[1] == location[1]) {
                ++origin;
            } else {
                angles.push_back(atan2(p[1] - location[1], p[0] - location[0]) * 180 / M_PI);
            }
        }
        sort(angles.begin(), angles.end());
        int n = angles.size();
        for (auto& a : angles) {
            a += 360;
        }
        copy(angles.begin(), angles.end(), back_inserter(angles));
        int res = 0;
        int i = 0;
        for (int j = 0; j < angles.size(); ++j) {
            while (angles[j] - angles[i] > angle) {
                ++i;
            }
            res = max(res, j - i + 1);
        }
        return res + origin;
    }
};