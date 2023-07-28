class Solution {
public:
    int numPoints(vector<vector<int>>& darts, int r) {
        
        int n = darts.size();
        int res = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int d = (darts[i][0] - darts[j][0]) * (darts[i][0] - darts[j][0]) + (darts[i][1] - darts[j][1]) * (darts[i][1] - darts[j][1]);
                if (d > 4 * r * r) continue;
                int x1 = darts[i][0], y1 = darts[i][1], x2 = darts[j][0], y2 = darts[j][1];
                int x0 = (x1 + x2) / 2;
                int y0 = (y1 + y2) / 2;
                int dx = x2 - x1, dy = y2 - y1;
                int d1 = sqrt(r * r - d / 4.0);
                int x01 = x0 + d1 * dy / sqrt(dx * dx + dy * dy);
                int y01 = y0 - d1 * dx / sqrt(dx * dx + dy * dy);
                int x02 = x0 - d1 * dy / sqrt(dx * dx + dy * dy);
                int y02 = y0 + d1 * dx / sqrt(dx * dx + dy * dy);
                int cnt = 0;
                for (int k = 0; k < n; ++k) {
                    if ((darts[k][0] - x01) * (darts[k][0] - x01) + (darts[k][1] - y01) * (darts[k][1] - y01) <= r * r) {
                        ++cnt;
                    }
                    if ((darts[k][0] - x02) * (darts[k][0] - x02) + (darts[k][1] - y02) * (darts[k][1] - y02) <= r * r) {
                        ++cnt;
                    }
                }
                res = max(res, cnt);
            }
        }
        return res;
    }
};