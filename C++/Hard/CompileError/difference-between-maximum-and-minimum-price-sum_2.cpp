class Solution {
public:
    long long maxOutput(int n, vector<vector<int>>& edges, vector<int>& price) {
        
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> sum);
        dfs(adj, price, sum, 0, -1);
        long long res = 0;
        for (int i = 0; i < n; ++i)
            res = max(res, (long long)sum[i] * (accumulate(price.begin(), price.end(), 0) - sum[i]));
        return res;
    }

    void dfs(vector<vector<int>>& adj, vector<int>& price, vector<int>& sum, int cur, int parent) {
        sum[cur] = price[cur];
        for (int next   adj[cur]) {
            if (next != parent) {
                dfs(adj, price, sum, next, cur);
                sum[cur] += sum[next];
            }
        }
    }
};