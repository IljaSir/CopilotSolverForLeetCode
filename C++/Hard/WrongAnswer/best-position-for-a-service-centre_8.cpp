class Solution {
public:
    double getMinDistSum(vector<vector<int>>& positions) {
        
        double x = 50, y = 50, step = 50;
        for (int i = 0; i < 100; ++i) {
            double minSum = getSum(positions, x, y);
            double minx = x, miny = y;
            for (int j = 0; j < 4; ++j) {
                double curx = x + step * (j % 2 == 0 ? 1 : -1);
                double cury = y + step * (j / 2 == 0 ? 1 : -1);
                double curSum = getSum(positions, curx, cury);
                if (curSum < minSum) {
                    minSum = curSum;
                    minx = curx;
                    miny = cury;
                }
            }
            x = minx;
            y = miny;
            step /= 2;
        }
        return getSum(positions, x, y);
    }
    
    double getSum(vector<vector<int>>& positions, double x, double y) {
        double sum = 0;
        for (auto& pos : positions) {
            sum += sqrt((pos[0] - x) * (pos[0] - x) + (pos[1] - y) * (pos[1] - y));
        }
        return sum;
    }
};