class Solution {
public:
    int numberOfGoodPaths(vector<int>& vals, vector<vector<int>>& edges) {
        
        int n = vals.size();
        vector<vector<int>> g(n);
        for (auto &e: edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> f(n);
        vector<int> s(n);
        s[0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                f[j] = 0;
            }
            for (int j = 0; j < n; ++j) {
                if (vals[j] > vals[i]) continue;
                for (auto &v: g[j]) {
                    if (vals[v] > vals[i]) continue;
                    f[j] = (f[j] + s[v]) % 1000000007;
                }
            }
            s = f;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = (ans + s[i]) % 1000000007;
        }
        return ans;
    }
};