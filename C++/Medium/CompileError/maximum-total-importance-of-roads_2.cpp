class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        
        vector<vector<int>> adj(n);
        for (auto& road : roads) {
            adj[road[0]].push_back(road[1]);
            adj[road[1]].push_back(road[0]);
        }

        vector<int> val(n);
        for (int i = 0; i < n; ++i) {
            val[i] = i + 1;
        }
        long long ans = 0;
        vector<bool> visited(n);
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                long long sum = 0;
                dfs(i, adj, val, visited, sum);
                ans += sum;
            }
        }
        return ans;
    }
};