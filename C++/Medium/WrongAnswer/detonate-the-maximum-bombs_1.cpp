class Solution {
public:
    int maximumDetonation(vector<vector<int>>& bombs) {
        
        int n = bombs.size();
        vector<vector<int>> ranges(n);
        for (int i = 0; i < n; i++) {
            int x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
            ranges[i] = {x - r, x + r, y - r, y + r};
        }
        int res = 1;
        for (int i = 0; i < n; i++) {
            int cur = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (ranges[j][0] <= ranges[i][0] && ranges[i][1] <= ranges[j][1] && ranges[j][2] <= ranges[i][2] && ranges[i][3] <= ranges[j][3]) {
                    cur++;
                }
            }
            res = max(res, cur);
        }
        return res;
    }
};