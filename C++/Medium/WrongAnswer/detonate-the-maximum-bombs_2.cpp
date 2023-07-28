class Solution {
public:
    int maximumDetonation(vector<vector<int>>& bombs) {
        
        int n = bombs.size();
        vector<int> d(n);
        for (int i = 0; i < n; ++i) {
            d[i] = bombs[i][2];
        }
        sort(d.begin(), d.end());
        d.erase(unique(d.begin(), d.end()), d.end());
        int m = d.size();
        vector<int> f(m);
        for (int i = 0; i < n; ++i) {
            int x = lower_bound(d.begin(), d.end(), bombs[i][2]) - d.begin();
            ++f[x];
        }
        vector<int> g(m);
        g[0] = f[0];
        for (int i = 1; i < m; ++i) {
            g[i] = g[i - 1] + f[i];
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int x = lower_bound(d.begin(), d.end(), bombs[i][2]) - d.begin();
            res = max(res, g[x]);
        }
        return res;
    }
};