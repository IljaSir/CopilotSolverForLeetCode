class Solution {
public:
    int minAreaRect(vector<vector<int>>& points) {
        
        int n = points.size();
        if (n < 4) return 0;
        unordered_map<int, set<int>> m;
        for (auto& p : points) m[p[0]].insert(p[1]);
        int ans = INT_MAX;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                if (x1 == x2 || y1 == y2) continue;
                if (m[x1].count(y2) && m[x2].count(y1)) {
                    ans = min(ans, abs(x1 - x2) * abs(y1 - y2));
                }
            }
        }
        return ans == INT_MAX ? 0 : ans;
    }
};