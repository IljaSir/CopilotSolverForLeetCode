class Solution {
public:
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> graph(n);
        for (auto& e: connections) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<int> rank(n, -1);
        vector<vector<int>> result;
        function<int(int, int)> dfs = [&](int node, int depth) {
            if (rank[node] != -1) {
                return rank[node];
            }
            rank[node] = depth;
            int minRank = depth;
            for (int next: graph[node]) {
                if (rank[next] == depth - 1) {
                    continue;
                }
                int nextRank = dfs(next, depth + 1);
                if (nextRank <= depth) {
                    continue;
                }
                result.push_back({node, next});
            }
            return minRank;
        };
        dfs(0, 0);
        return result;
    }
};