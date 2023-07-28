class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        
        if (points.size() < 3) return points.size();
        int res = 0;
        for (int i = 0; i < points.size(); ++i) {
            int same = 1;
            unordered_map<string, int> m;
            for (int j = i + 1; j < points.size(); ++j) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    ++same;
                } else {
                    int x = points[i][0] - points[j][0];
                    int y = points[i][1] - points[j][1];
                    int d = gcd(x, y);
                    ++m[to_string(x / d) + "_" + to_string(y / d)];
                }
            }
            res = max(res, same);
            for (auto &p : m) {
                res = max(res, p.second + same);
            }
        }
        return res;
    }
};