class Solution {
public:
    double getMinDistSum(vector<vector<int>>& positions) {
        
        double x = 0, y = 0, step = 100;
        for (int i = 0; i < 100; ++i) {
            double best = 1e9;
            int bx, by;
            for (int dx = -1; dx <= 1; ++dx) {
                for (int dy = -1; dy <= 1; ++dy) {
                    double sum = 0;
                    for (auto& p : positions) {
                        sum += sqrt((p[0] - x - dx * step) * (p[0] - x - dx * step) + (p[1] - y - dy * step) * (p[1] - y - dy * step));
                    }
                    if (sum < best) {
                        best = sum;
                        bx = dx;
                        by = dy;
                    }
                }
            }
            x += bx * step;
            y += by * step;
            step /= 2;
        }
        return best;
    }
};