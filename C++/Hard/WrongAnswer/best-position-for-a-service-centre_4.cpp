class Solution {
public:
    double getMinDistSum(vector<vector<int>>& positions) {
        
        double x = 50, y = 50, step = 100, eps = 1e-6;
        int n = positions.size();
        while (step > eps) {
            double nx = x, ny = y;
            for (int i = 0; i < n; i++) {
                double dx = positions[i][0] - x, dy = positions[i][1] - y;
                double dist = sqrt(dx*dx + dy*dy);
                nx += step * dx / dist;
                ny += step * dy / dist;
            }
            x = nx;
            y = ny;
            step *= 0.99;
        }
        double res = 0;
        for (int i = 0; i < n; i++) {
            double dx = positions[i][0] - x, dy = positions[i][1] - y;
            res += sqrt(dx*dx + dy*dy);
        }
        return res;
    }
};