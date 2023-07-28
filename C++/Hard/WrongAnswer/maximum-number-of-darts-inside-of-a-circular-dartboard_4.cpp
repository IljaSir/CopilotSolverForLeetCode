class Solution {
public:
    int numPoints(vector<vector<int>>& darts, int r) {
        
        int n = darts.size();
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx = darts[i][0] - darts[j][0];
                int dy = darts[i][1] - darts[j][1];
                if (dx * dx + dy * dy > 4 * r * r) continue;
                double cx = (darts[i][0] + darts[j][0]) / 2.0;
                double cy = (darts[i][1] + darts[j][1]) / 2.0;
                double k = sqrt(r * r - (dx * dx + dy * dy) / 4.0);
                double nx = k * dy / sqrt(dx * dx + dy * dy);
                double ny = -k * dx / sqrt(dx * dx + dy * dy);
                double x1 = cx + nx, y1 = cy + ny;
                double x2 = cx - nx, y2 = cy - ny;
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if (pow(darts[k][0] - x1, 2) + pow(darts[k][1] - y1, 2) <= r * r) cnt++;
                    if (pow(darts[k][0] - x2, 2) + pow(darts[k][1] - y2, 2) <= r * r) cnt++;
                }
                ans = max(ans, cnt);
            }
        }
        return ans;
    }
};