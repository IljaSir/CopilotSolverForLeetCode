class Solution {
public:
    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        
        int n = roads.size()+1;
        vector<vector<int>> g(n);
        for(auto& e: roads) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> sz(n);
        function<void(int,int)> dfs = [&](int u, int p) {
            sz[u] = 1;
            for(int v: g[u]) if(v != p) {
                dfs(v, u);
                sz[u] += sz[v];
            }
        };
        dfs(0, -1);
        vector<int> f(n);
        function<void(int,int)> dfs2 = [&](int u, int p) {
            f[u] = 0;
            for(int v: g[u]) if(v != p) {
                dfs2(v, u);
                f[u] += f[v];
            }
            f[u] += sz[u]-1;
        };
        dfs2(0, -1);
        sort(f.begin(), f.end(), greater<int>());
        long long ans = 0;
        for(int i = 0; i < seats; i++) {
            ans += f[i];
        }
        return ans;
    }
};