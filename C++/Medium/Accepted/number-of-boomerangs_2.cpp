class Solution {
public:
    int numberOfBoomerangs(vector<vector<int>>& points) {
        
        int n = points.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            unordered_map<int, int> cnt;
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    continue;
                }
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                ++cnt[dx * dx + dy * dy];
            }
            for (auto [_, m] : cnt) {
                ans += m * (m - 1);
            }
        }
        return ans;
    }
};