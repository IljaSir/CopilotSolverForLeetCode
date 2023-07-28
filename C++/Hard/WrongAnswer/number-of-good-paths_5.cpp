class Solution {
public:
    int numberOfGoodPaths(vector<int>& vals, vector<vector<int>>& edges) {
        
        int n = vals.size();
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<vector<int>> dp(n, vector<int>(n, 0));
        vector<bool> visited(n, false);
        dfs(vals, graph, dp, visited, 0);
        return dp[0][0];
    }
    void dfs(vector<int>& vals, vector<vector<int>>& graph, vector<vector<int>>& dp, vector<bool>& visited, int node) {
        visited[node] = true;
        for (int i = node; i < vals.size(); ++i) {
            if (vals[i] <= vals[node]) {
                dp[node][i] = 1;
            }
        }
        for (int nei : graph[node]) {
            if (visited[nei]) continue;
            dfs(vals, graph, dp, visited, nei);
            for (int i = node; i < vals.size(); ++i) {
                if (vals[i] <= vals[node]) {
                    dp[node][i] = (dp[node][i] + dp[nei][i]) % 1000000007;
                }
            }
        }
    }
};