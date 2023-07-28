class Solution {
public:
    double getMinDistSum(vector<vector<int>>& positions) {
        
        double cx = 0, cy = 0, step = 100, eps = 1e-6;
        for (int i = 0; i < 100; ++i) {
            vector<pair<double, double>> cand = {{cx + step, cy}, {cx - step, cy}, {cx, cy + step}, {cx, cy - step}};
            auto best = cand[0];
            for (auto& p : cand) {
                if (getDistSum(positions, p.first, p.second) < getDistSum(positions, best.first, best.second)) {
                    best = p;
                }
            }
            cx = best.first;
            cy = best.second;
            step *= 0.99;
        }
        return getDistSum(positions, cx, cy);
    }
    
    double getDistSum(vector<vector<int>>& positions, double cx, double cy) {
        double sum = 0;
        for (auto& p : positions) {
            sum += sqrt(pow(p[0] - cx, 2) + pow(p[1] - cy, 2));
        }
        return sum;
    }
};