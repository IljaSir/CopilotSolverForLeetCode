class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        
        int n = points.size();
        if (n < 3) return n;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int duplicate = 1;
            unordered_map<string, int> m;
            for (int j = i + 1; j < n; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    duplicate++;
                    continue;
                }
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int d = gcd(dx, dy);
                m[to_string(dx / d) + "_" + to_string(dy / d)]++;
            }
            res = max(res, duplicate);
            for (auto it = m.begin(); it != m.end(); it++) {
                res = max(res, it->second + duplicate);
            }
        }
        return res;
    }
};