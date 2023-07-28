class Solution {
public:
    double getMinDistSum(vector<vector<int>>& positions) {
        
        int n = positions.size();
        double x = 0, y = 0;
        double step = 100, eps = 1e-7;
        while (step > eps) {
            double best = 1e9;
            int nx = 0, ny = 0;
            for (int dx = -1; dx <= 1; ++dx) {
                for (int dy = -1; dy <= 1; ++dy) {
                    double nx = x + dx * step, ny = y + dy * step;
                    double sum = 0;
                    for (auto& p : positions) {
                        sum += sqrt((nx - p[0]) * (nx - p[0]) + (ny - p[1]) * (ny - p[1]));
                    }
                    if (sum < best) {
                        best = sum;
                        x = nx;
                        y = ny;
                    }
                }
            }
            step /= 2;
        }
        return best;
    }
};