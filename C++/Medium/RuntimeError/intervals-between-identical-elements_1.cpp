class Solution {
public:
    vector<long long> getDistances(vector<int>& arr) {
        
        unordered_map<int, vector<int>> m;
        for(int i = 0; i < arr.size(); i++) {
            m[arr[i]].push_back(i);
        }
        vector<long long> res(arr.size(), 0);
        for(auto& it : m) {
            vector<int>& v = it.second;
            for(int i = 0; i < v.size(); i++) {
                res[v[i]] += (long long)(i) * (v[i] - v[i - 1]);
            }
            for(int i = v.size() - 1; i >= 0; i--) {
                res[v[i]] += (long long)(v.size() - i - 1) * (v[i + 1] - v[i]);
            }
        }
        return res;
    }
    vector<long long> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        vector<vector<int>> g(n, vector<int>());
        for(auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> arr(n);
        vector<int> sz(n);
        function<void(int, int)> dfs1 = [&](int u, int p) {
            sz[u] = 1;
            for(int v : g[u]) {
                if(v == p) continue;
                dfs1(v, u);
                sz[u] += sz[v];
                arr[u] += arr[v] + sz[v];
            }
        };
        function<void(int, int)> dfs2 = [&](int u, int p) {
            for(int v : g[u]) {
                if(v == p) continue;
                arr[v] = arr[u] - 2 * sz[v] + n;
                dfs2(v, u);
            }
        };
        dfs1(0, -1);
        dfs2(0, -1);
        return getDistances(arr);
    }
};