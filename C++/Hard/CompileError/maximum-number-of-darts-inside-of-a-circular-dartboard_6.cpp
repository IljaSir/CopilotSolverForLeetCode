class Solution {
public:
    int numPoints(vector<vector<int>>& darts, int r) {
        
        int n = darts.size();
        vector<vector<int>> dist(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                dist[i][j] = dist[j][i] = (darts[i][0] - darts[j][0]) * (darts[i][0] - darts[j][0]) + (darts[i][1] - darts[j][1]) * (darts[i][1] - darts[j][1]);
            }
        }
        int ans = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int d = dist[i][j];
                if (d > 4 * r * r) {
                    continue;
                }
                int cnt = 0;
                for (int k = 0; k < n; ++k) {
                    int dx = darts[k][0] - darts[i][0];
                    int dy = darts[k][1] - darts[i][1];
                    if (dx * dx + dy * dy <= r * r) {
                        ++cnt;
                    }
                }
                ans = max(ans, cnt);
                int h = sqrt(r * r - d / 4.0);
                int l = d / 2;
                double theta = acos(h / sqrt(l * l + h * h));
                double phi = atan2(darts[j][1] - darts[i][1], darts[j][0] - darts[i][0]);
                double alpha = phi - theta;
                double beta = phi + theta;
                vector<double> angles;
                for (int k = 0; k < n; ++k) {
                    int dx = darts[k][0] - darts[i][0];
                    int dy = darts[k][1] - darts[i][1];
                    if (dx * dx + dy * dy <= r * r) {
                        double angle = atan2(dy, dx);
                        if (angle < 0) {
                            angle += 2 * acos(-1);
                        }
                        angles.push_back(angle);
                    }
                }
    }
};