class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        
        if (points.size() < 3) return points.size();
        int res = 0;
        for (int i = 0; i < points.size(); ++i) {
            unordered_map<int, int> mp;
            int same = 1;
            for (int j = i + 1; j < points.size(); ++j) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    ++same;
                } else {
                    int dx = points[i][0] - points[j][0];
                    int dy = points[i][1] - points[j][1];
                    int gcd = __gcd(dx, dy);
                    ++mp[(dx / gcd) * 10000 + dy / gcd];
                }
            }
            int local = 0;
            for (auto& m : mp) {
                local = max(local, m.second);
            }
            local += same;
            res = max(res, local);
        }
        return res;
    }
};