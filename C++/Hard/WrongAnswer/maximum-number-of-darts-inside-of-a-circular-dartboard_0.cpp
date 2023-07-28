class Solution {
public:
    int numPoints(vector<vector<int>>& darts, int r) {
        
        int n = darts.size();
        int ans = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int x1 = darts[i][0], y1 = darts[i][1];
                int x2 = darts[j][0], y2 = darts[j][1];
                if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) > 4 * r * r) continue;
                int x0 = (x1 + x2) / 2, y0 = (y1 + y2) / 2;
                int d = sqrt(r * r - (x1 - x0) * (x1 - x0) - (y1 - y0) * (y1 - y0));
                int dx = -(y1 - y2), dy = x1 - x2;
                int x3 = x0 + d * dx, y3 = y0 + d * dy;
                int x4 = x0 - d * dx, y4 = y0 - d * dy;
                int cnt1 = 0, cnt2 = 0;
                for (int k = 0; k < n; ++k) {
                    int x = darts[k][0], y = darts[k][1];
                    if ((x - x3) * (x - x3) + (y - y3) * (y - y3) <= r * r) ++cnt1;
                    if ((x - x4) * (x - x4) + (y - y4) * (y - y4) <= r * r) ++cnt2;
                }
                ans = max(ans, max(cnt1, cnt2));
            }
        }
        return ans;
    }
};