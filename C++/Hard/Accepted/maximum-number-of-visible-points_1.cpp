class Solution {
public:
    int visiblePoints(vector<vector<int>>& points, int angle, vector<int>& location) {
        
        vector<double> angles;
        int samePoint = 0;
        for (auto& point : points) {
            if (point[0] == location[0] && point[1] == location[1]) {
                samePoint++;
                continue;
            }
            angles.push_back(atan2(point[1] - location[1], point[0] - location[0]) * 180 / M_PI);
        }
        sort(angles.begin(), angles.end());
        int n = angles.size();
        for (int i = 0; i < n; i++) {
            angles.push_back(angles[i] + 360);
        }
        int ans = samePoint;
        int i = 0;
        for (int j = 0; j < angles.size(); j++) {
            while (angles[j] - angles[i] > angle) {
                i++;
            }
            ans = max(ans, j - i + 1 + samePoint);
        }
        return ans;
    }
};