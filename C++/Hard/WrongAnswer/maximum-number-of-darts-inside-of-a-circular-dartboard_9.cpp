class Solution {
public:
    int numPoints(vector<vector<int>>& darts, int r) {
        
        int n = darts.size(), res = 1;
        double R = r;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                double d = sqrt(pow(darts[i][0] - darts[j][0], 2) + pow(darts[i][1] - darts[j][1], 2));
                if (d > 2 * R) continue;
                double a = acos(d / (2 * R));
                double b = atan2(darts[j][1] - darts[i][1], darts[j][0] - darts[i][0]);
                double t1 = b - a + M_PI, t2 = b + a + M_PI;
                vector<double> ts = {t1, t2, t1 + 2 * M_PI, t2 + 2 * M_PI};
                for (auto t : ts) {
                    int cnt = 0;
                    for (auto& dart : darts) {
                        if (pow(dart[0] - R * cos(t), 2) + pow(dart[1] - R * sin(t), 2) <= R * R + 1e-6) {
                            ++cnt;
                        }
                    }
                    res = max(res, cnt);
                }
            }
        }
        return res;
    }
};