class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        
        vector<vector<int>> graph(n);
        for (auto& road: roads) {
            graph[road[0]].push_back(road[1]);
            graph[road[1]].push_back(road[0]);
        }
        vector<int> visited(n, 0);
        vector<int> values(n, 0);
        for (int i = 0; i < n; ++i) {
            if (visited[i] == 0) {
                visited[i] = 1;
                dfs(graph, i, visited, values);
            }
        }
        long long ans = 0;
        for (auto& road: roads) {
            ans += (long long) values[road[0]] * values[road[1]];
        }
        return ans;
    }
    
    int dfs(vector<vector<int>>& graph, int root, vector<int>& visited, vector<int>& values) {
        int total = 1;
        for (auto& child: graph[root]) {
            if (visited[child] == 0) {
                visited[child] = 1;
                int subtree = dfs(graph, child, visited, values);
                values[root] += subtree;
                total += subtree;
            }
        }
        values[root] += 1;
        return total;
    }
};