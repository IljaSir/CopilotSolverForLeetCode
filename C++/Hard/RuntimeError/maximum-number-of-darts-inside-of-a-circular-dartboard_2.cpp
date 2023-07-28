class Solution {
public:
    int numPoints(vector<vector<int>>& darts, int r) {
        
        int n = darts.size(), res = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int x1 = darts[i][0], y1 = darts[i][1];
                int x2 = darts[j][0], y2 = darts[j][1];
                if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) > 4 * r * r) continue;
                int x0 = (x1 + x2) / 2, y0 = (y1 + y2) / 2;
                int a = y1 - y0, b = x0 - x1, c = x1 * y0 - x0 * y1;
                int d = a * a + b * b;
                double cx = (b * b * x0 - a * b * y0 - a * c) / d;
                double cy = (a * a * y0 - a * b * x0 - b * c) / d;
                int cnt = 0;
                for (auto v : darts) {
                    int x = v[0], y = v[1];
                    if ((x - cx) * (x - cx) + (y - cy) * (y - cy) <= r * r) ++cnt;
                }
                res = max(res, cnt);
            }
        }
        return res;
    }
};