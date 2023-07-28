class Solution {
public:
    int maximumDetonation(vector<vector<int>>& bombs) {
        
        int n = bombs.size();
        vector<int> ans(n);
        vector<int> r(n);
        for (int i = 0; i < n; ++i) {
            r[i] = bombs[i][2];
        }
        sort(r.begin(), r.end());
        for (int i = 0; i < n; ++i) {
            int x = bombs[i][0];
            int y = bombs[i][1];
            int r = bombs[i][2];
            int l = 0, h = n - 1;
            while (l < h) {
                int m = l + (h - l) / 2;
                if (r[m] < r) {
                    l = m + 1;
                } else {
                    h = m;
                }
            }
            int cnt = 0;
            for (int j = l; j < n; ++j) {
                int x1 = bombs[j][0];
                int y1 = bombs[j][1];
                int r1 = bombs[j][2];
                if (r1 > r && sqrt(pow(x1 - x, 2) + pow(y1 - y, 2)) <= r1 - r) {
                    ++cnt;
                }
            }
            ans[i] = cnt + 1;
        }
        return *max_element(ans.begin(), ans.end());
    }
};