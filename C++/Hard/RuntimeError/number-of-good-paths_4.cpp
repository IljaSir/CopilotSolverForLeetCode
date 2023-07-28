class Solution {
public:
    int numberOfGoodPaths(vector<int>& vals, vector<vector<int>>& edges) {
        
        int n = vals.size();
        vector<vector<int>> g(n);
        for (auto &e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> cnt(n);
        vector<int> f(n);
        function<void(int, int)> dfs = [&](int x, int fa) {
            cnt[x] = vals[x] == vals[0];
            f[x] = vals[x] == vals[0];
            for (auto y : g[x]) {
                if (y == fa) continue;
                dfs(y, x);
                cnt[x] += cnt[y];
                f[x] += f[y];
            }
        };
        dfs(0, -1);
        function<int(int, int)> calc = [&](int x, int fa) {
            int res = 0;
            for (auto y : g[x]) {
                if (y == fa) continue;
                res += calc(y, x);
            }
            int tot = cnt[x] - cnt[fa];
            int cur = f[x] - f[fa];
            res += cur * (tot - cur);
            return res;
        };
        return calc(0, -1);
    }
};