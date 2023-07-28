class Solution {
public:
    int numPoints(vector<vector<int>>& darts, int r) {
        
        int n = darts.size(), res = 1;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j) {
                auto [x1, y1] = darts[i], [x2, y2] = darts[j];
                int dx = x2 - x1, dy = y2 - y1;
                if (dx * dx + dy * dy > 4 * r * r) continue;
                double mx = (x1 + x2) / 2., my = (y1 + y2) / 2.,
                       d = sqrt(r * r - (dx * dx + dy * dy) / 4.),
                       nx = dy * d / sqrt(dx * dx + dy * dy),
                       ny = dx * d / sqrt(dx * dx + dy * dy);
                vector<pair<double, double>> p = {{mx + nx, my - ny}, {mx - nx, my + ny}};
                for (auto [x, y] : p) {
                    int cnt = 0;
                    for (auto [xx, yy] : darts)
                        if ((xx - x) * (xx - x) + (yy - y) * (yy - y) <= r * r)
                            ++cnt;
                    res = max(res, cnt);
                }
            }
        return res;
    }
};