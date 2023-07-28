class Solution {
public:
    int visiblePoints(vector<vector<int>>& points, int angle, vector<int>& location) {
        
        int n = points.size();
        int x = location[0], y = location[1];
        vector<double> v;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (points[i][0] == x && points[i][1] == y) {
                cnt++;
            } else {
                double a = atan2(points[i][1] - y, points[i][0] - x) * 180.0 / acos(-1.0);
                v.push_back(a);
            }
        }
        int m = v.size();
        sort(v.begin(), v.end());
        for (int i = 0; i < m; i++) {
            v.push_back(v[i] + 360);
        }
        int ans = cnt;
        for (int i = 0, j = 0; i < m; i++) {
            while (j - i < m && v[j] - v[i] <= angle) {
                j++;
            }
            ans = max(ans, j - i + cnt);
        }
        return ans;
    }
};