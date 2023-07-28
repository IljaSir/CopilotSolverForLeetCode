class Solution {
public:
    int visiblePoints(vector<vector<int>>& points, int angle, vector<int>& location) {
        
        int x = location[0], y = location[1];
        vector<double> angles;
        int same = 0;
        for (auto& p : points) {
            if (p[0] == x && p[1] == y) {
                same++;
                continue;
            }
            angles.push_back(atan2(p[1] - y, p[0] - x) * 180 / M_PI);
        }
        sort(angles.begin(), angles.end());
        int n = angles.size();
        for (int i = 0; i < n; i++) {
            angles.push_back(angles[i] + 360);
        }
        int ans = same;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < angles.size() && angles[j] - angles[i] <= angle) {
                j++;
            }
            ans = max(ans, j - i + same);
        }
        return ans;
    }
};