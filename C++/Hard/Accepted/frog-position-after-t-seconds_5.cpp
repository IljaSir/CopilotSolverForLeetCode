class Solution {
public:
    double frogPosition(int n, vector<vector<int>>& edges, int t, int target) {
        
        vector<vector<int>> graph(n+1, vector<int>());
        for (auto& edge: edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<int> visited(n+1, 0);
        visited[1] = 1;
        return dfs(graph, visited, 1, t, target);
    }
    double dfs(vector<vector<int>>& graph, vector<int>& visited, int cur, int t, int target) {
        if (t == 0) {
            return cur == target ? 1 : 0;
        }
        int count = 0;
        for (auto next: graph[cur]) {
            if (visited[next] == 0) {
                count++;
            }
        }
        if (count == 0) {
            return cur == target ? 1 : 0;
        }
        double prob = 0;
        for (auto next: graph[cur]) {
            if (visited[next] == 0) {
                visited[next] = 1;
                prob += dfs(graph, visited, next, t-1, target) / count;
                visited[next] = 0;
            }
        }
        return prob;
    }
};