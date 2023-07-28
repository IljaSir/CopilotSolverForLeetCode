class Solution {
public:
    int maxBuilding(int n, vector<vector<int>>& restrictions) {
        
        restrictions.push_back({1, 0});
        sort(restrictions.begin(), restrictions.end());
        for (int i = 1; i < restrictions.size(); ++i) {
            int delta = restrictions[i][0] - restrictions[i - 1][0];
            restrictions[i][1] = min(restrictions[i][1], restrictions[i - 1][1] + delta);
        }
        for (int i = restrictions.size() - 2; i >= 0; --i) {
            int delta = restrictions[i + 1][0] - restrictions[i][0];
            restrictions[i][1] = min(restrictions[i][1], restrictions[i + 1][1] + delta);
        }
        int ans = 0;
        for (int i = 1; i < restrictions.size(); ++i) {
            int x1 = restrictions[i - 1][0], y1 = restrictions[i - 1][1];
            int x2 = restrictions[i][0], y2 = restrictions[i][1];
            int delta = x2 - x1;
            int y = (y1 + y2 + delta) / 2;
            ans = max(ans, y);
        }
        return ans;
    }
};