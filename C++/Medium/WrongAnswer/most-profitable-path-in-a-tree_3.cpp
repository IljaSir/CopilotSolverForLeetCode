class Solution {
public:
    int mostProfitablePath(vector<vector<int>>& edges, int bob, vector<int>& amount) {
        
        vector<vector<int>> g(amount.size());
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> dp(amount.size(), -1);
        int ans = 0;
        function<int(int, int)> dfs = [&](int u, int fa) {
            int sum = 0;
            for (int v : g[u]) {
                if (v != fa) {
                    sum += dfs(v, u);
                }
            }
            if (u == bob) {
                sum += amount[u];
            }
            if (sum > 0) {
                ans += sum / 2;
            }
            return sum;
        };
        dfs(0, -1);
        return ans;
    }
};