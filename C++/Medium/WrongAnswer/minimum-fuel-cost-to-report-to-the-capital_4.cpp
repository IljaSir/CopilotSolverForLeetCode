class Solution {
public:
    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        
        int n = roads.size() + 1;
        vector<vector<int>> g(n);
        for (auto& road : roads) {
            g[road[0]].push_back(road[1]);
            g[road[1]].push_back(road[0]);
        }
        vector<int> dp(n, 0);
        dfs(0, -1, g, dp);
        priority_queue<int> pq;
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[i] > 0) {
                pq.push(dp[i]);
                ans += dp[i];
            }
        }
        for (int i = 0; i < n - seats; ++i) {
            int t = pq.top();
            pq.pop();
            ans -= t - 1;
            pq.push(t - 1);
        }
        return ans;
    }
    
    void dfs(int u, int prev, vector<vector<int>>& g, vector<int>& dp) {
        for (int v : g[u]) {
            if (v == prev) continue;
            dfs(v, u, g, dp);
            dp[u] += dp[v];
        }
        dp[u]++;
    }
};