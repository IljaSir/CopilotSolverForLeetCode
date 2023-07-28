class Solution {
public:
    double getMinDistSum(vector<vector<int>>& positions) {
        
        double x = 50, y = 50;
        double step = 100;
        double eps = 1e-7;
        double ans = 1e15;
        while (step > eps) {
            double minAns = ans;
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0) {
                        continue;
                    }
                    double nx = x + step * dx;
                    double ny = y + step * dy;
                    double temp = 0;
                    for (auto& pos : positions) {
                        temp += sqrt((nx - pos[0]) * (nx - pos[0]) + (ny - pos[1]) * (ny - pos[1]));
                    }
                    if (temp < minAns) {
                        minAns = temp;
                        x = nx;
                        y = ny;
                    }
                }
            }
            ans = minAns;
            step /= 2;
        }
        return ans;
    }
};