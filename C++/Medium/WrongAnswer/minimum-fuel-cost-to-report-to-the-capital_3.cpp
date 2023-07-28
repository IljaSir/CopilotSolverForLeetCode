class Solution {
public:
    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        
        int n = roads.size() + 1;
        vector<vector<int>> g(n);
        for (auto& road : roads) {
            g[road[0]].push_back(road[1]);
            g[road[1]].push_back(road[0]);
        }
        vector<int> sons(n);
        vector<long long> dp(n);
        function<void(int, int)> dfs = [&](int u, int p) {
            sons[u] = 1;
            for (int v : g[u]) {
                if (v == p) continue;
                dfs(v, u);
                sons[u] += sons[v];
                dp[u] += dp[v] + sons[v];
            }
        };
        dfs(0, -1);
        vector<int> tmp;
        for (int v : g[0]) {
            tmp.push_back(sons[v]);
        }
        sort(tmp.begin(), tmp.end());
        long long ans = dp[0];
        for (int i = 0; i < tmp.size(); i++) {
            ans += 1LL * (i + 1) * tmp[i];
        }
        return ans;
    }
};