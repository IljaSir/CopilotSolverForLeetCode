class Solution {
public:
    int removeStones(vector<vector<int>>& stones) {
        
        int N = stones.size();
        vector<vector<int>> graph(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    graph[i].push_back(j);
                    graph[j].push_back(i);
                }
            }
        }
        vector<bool> visited(N, false);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                ans += dfs(i, graph, visited) - 1;
            }
        }
        return ans;
    }
    int dfs(int i, vector<vector<int>>& graph, vector<bool>& visited) {
        visited[i] = true;
        int ans = 1;
        for (int j : graph[i]) {
            if (!visited[j]) {
                ans += dfs(j, graph, visited);
            }
        }
        return ans;
    }
};