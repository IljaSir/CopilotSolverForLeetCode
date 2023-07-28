class Solution {
public:
    int numPoints(vector<vector<int>>& darts, int r) {
        
        int n = darts.size();
        int ans = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int x1 = darts[i][0], y1 = darts[i][1];
                int x2 = darts[j][0], y2 = darts[j][1];
                int dx = x1 - x2, dy = y1 - y2;
                if (dx * dx + dy * dy > 4 * r * r) {
                    continue;
                }
                vector<int> center = getCenter(x1, y1, x2, y2, r);
                int cnt = 0;
                for (auto& dart : darts) {
                    int x = dart[0], y = dart[1];
                    if ((x - center[0]) * (x - center[0]) + (y - center[1]) * (y - center[1]) <= r * r) {
                        ++cnt;
                    }
                }
                ans = max(ans, cnt);
            }
        }
        return ans;
    }
};