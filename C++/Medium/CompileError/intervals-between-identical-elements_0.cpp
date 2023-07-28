class Solution {
public:
    vector<long long> getDistances(vector<int>& arr) {
        
        int n = arr.size();
        vector<long long> ans(n, 0);
        unordered_map<int, vector<int>> m;
        for (int i = 0; i < n; ++i) {
            m[arr[i]].push_back(i);
        }
        for (auto& [k, v] : m) {
            for (int i = 0; i < v.size(); ++i) {
                ans[v[i]] += (i + 1) * (v[i] - v[i - 1]);
                ans[v[i]] += (v.size() - i) * (v[i + 1] - v[i]);
            }
        }
        return ans;
    }
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        vector<int> ans(n, 0);
        vector<vector<int>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> sz(n, 0);
        function<void(int, int)> dfs = [&](int u, int p) {
            sz[u] = 1;
            for (int v : g[u]) {
                if (v != p) {
                    dfs(v, u);
                    sz[u] += sz[v];
                    ans[u] += ans[v] + sz[v];
                }
            }
        };
        function<void(int, int)> dfs2 = [&](int u, int p) {
            for (int v : g[u]) {
                if (v != p) {
                    ans[v] = ans[u] - sz[v] + n - sz[v];
                    dfs2(v, u);
                }
            }
        };
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        vector<int> ans(n, 0);
        vector<vector<int>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> sz(n, 0);
        function<void(int, int)> dfs = [&](int u, int p) {
            sz
    }
};