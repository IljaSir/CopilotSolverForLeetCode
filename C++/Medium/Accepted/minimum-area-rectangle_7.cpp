class Solution {
public:
    int minAreaRect(vector<vector<int>>& points) {
        
        int n = points.size();
        int ans = 1e9;
        unordered_map<int, unordered_set<int>> mp;
        for (auto p: points) {
            mp[p[0]].insert(p[1]);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                if (x1 != x2 && y1 != y2 && mp[x1].count(y2) && mp[x2].count(y1)) {
                    ans = min(ans, abs(x1 - x2) * abs(y1 - y2));
                }
            }
        }
        return ans == 1e9 ? 0 : ans;
    }
};