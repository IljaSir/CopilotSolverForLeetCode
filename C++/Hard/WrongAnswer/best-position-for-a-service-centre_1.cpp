class Solution {
public:
    double getMinDistSum(vector<vector<int>>& positions) {
        
        int n = positions.size();
        double x = 0, y = 0, step = 50;
        for (auto& p : positions) {
            x += p[0];
            y += p[1];
        }
        x /= n;
        y /= n;
        double ans = 1e9;
        for (int i = 0; i < 100; i++) {
            double best = 1e9;
            int dx = 0, dy = 0;
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    double sum = 0;
                    for (auto& p : positions) {
                        sum += sqrt(pow(x + j * step - p[0], 2) + pow(y + k * step - p[1], 2));
                    }
                    if (best > sum) {
                        best = sum;
                        dx = j;
                        dy = k;
                    }
                }
            }
            x += dx * step;
            y += dy * step;
            step /= 2;
            ans = min(ans, best);
        }
        return ans;
    }
};