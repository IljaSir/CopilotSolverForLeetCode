class Solution {
public:
    double getMinDistSum(vector<vector<int>>& positions) {
        
        double x = 0, y = 0, step = 100;
        for (int i = 0; i < 100; ++i) {
            double minDist = 1e9;
            for (int j = 0; j < 4; ++j) {
                double nx = x + (j % 2 ? 1 : -1) * step;
                double ny = y + (j / 2 ? 1 : -1) * step;
                double dist = 0;
                for (auto& p : positions) {
                    dist += sqrt(pow(p[0] - nx, 2) + pow(p[1] - ny, 2));
                }
                if (dist < minDist) {
                    minDist = dist;
                    x = nx;
                    y = ny;
                }
            }
            step /= 2;
        }
        return minDist;
    }
};