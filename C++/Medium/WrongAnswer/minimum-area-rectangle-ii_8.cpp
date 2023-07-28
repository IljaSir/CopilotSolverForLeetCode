class Solution {
public:
    double minAreaFreeRect(vector<vector<int>>& points) {
        
        unordered_map<double, unordered_map<double, unordered_map<double, unordered_map<double, int>>>> m;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                double x = (x1 + x2) / 2.0;
                double y = (y1 + y2) / 2.0;
                double dis = pow(x2 - x1, 2) + pow(y2 - y1, 2);
                m[x][y][dis][pow(x1 - x, 2) + pow(y1 - y, 2)]++;
            }
        }
        double res = INT_MAX;
        for (auto& [x, yMap] : m) {
            for (auto& [y, disMap] : yMap) {
                for (auto& [dis, lengthMap] : disMap) {
                    for (auto& [length, cnt] : lengthMap) {
                        if (cnt > 1) {
                            res = min(res, dis * length);
                        }
                    }
                }
            }
        }
        return res == INT_MAX ? 0 : res;
    }
};