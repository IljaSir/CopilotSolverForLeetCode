class Solution {
public:
    long long maxOutput(int n, vector<vector<int>>& edges, vector<int>& price) {
        
        vector<vector<int>> adj(n);
        for (auto& edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }
        vector<long long> sum(n);
        vector<long long> minSum(n);
        vector<long long> maxSum(n);
        vector<bool> visited(n);
        dfs(0, adj, price, sum, minSum, maxSum, visited);
        long long maxCost = 0;
        for (int i = 0; i < n; ++i) {
            maxCost = max(maxCost, maxSum[i] - minSum[i]);
        }
        return maxCost;
    }
};