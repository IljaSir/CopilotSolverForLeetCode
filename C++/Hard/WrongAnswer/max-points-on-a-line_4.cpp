class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        
        if (points.size() < 3) return points.size();
        int res = 0;
        for (int i = 0; i < points.size(); i++) {
            unordered_map<string, int> map;
            int same = 0;
            int maxn = 0;
            for (int j = i + 1; j < points.size(); j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    same++;
                    continue;
                }
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                int gcdXY = gcd(x, y);
                x /= gcdXY;
                y /= gcdXY;
                string key = to_string(x) + "/" + to_string(y);
                map[key]++;
                maxn = max(maxn, map[key]);
            }
            res = max(res, maxn + same + 1);
        }
        return res;
    }
};