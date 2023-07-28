class Solution {
public:
    double getMinDistSum(vector<vector<int>>& positions) {
        
        double x = 0, y = 0, step = 100, eps = 1e-6;
        for (int i = 0; i < 100; ++i) {
            double minDist = 1e9;
            int idx = -1;
            for (int j = 0; j < positions.size(); ++j) {
                double dist = distTo(positions[j][0], positions[j][1], x, y);
                if (dist < minDist) {
                    minDist = dist;
                    idx = j;
                }
            }
            x += step * (positions[idx][0] - x);
            y += step * (positions[idx][1] - y);
            step *= 0.99;
        }
        return getDist(positions, x, y);
    }
};