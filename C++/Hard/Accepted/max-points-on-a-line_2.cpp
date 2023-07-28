class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        
        int n = points.size();
        if (n < 3) return n;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            unordered_map<double, int> mp;
            int dup = 1;
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x1 == x2 && y1 == y2) {
                    dup++;
                    continue;
                }
                double k = x1 == x2 ? INT_MAX : (double)(y1 - y2) / (x1 - x2);
                mp[k]++;
            }
            int maxn = 0;
            for (auto& [_, val] : mp) {
                maxn = max(maxn, val);
            }
            ans = max(ans, maxn + dup);
        }
        return ans;
    }
};