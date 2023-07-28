class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        
        vector<vector<int>> graph(n);
        for (auto& r : roads) {
            graph[r[0]].push_back(r[1]);
            graph[r[1]].push_back(r[0]);
        }
        vector<int> visited(n, 0);
        long long sum = 0;
        dfs(graph, 0, visited, sum);
        return sum;
    }
    void dfs(vector<vector<int>>& graph, int cur, vector<int>& visited, long long& sum) {
        visited[cur] = 1;
        for (int next : graph[cur]) {
            if (visited[next] == 0) {
                sum += 1 + graph[cur].size() + graph[next].size();
                dfs(graph, next, visited, sum);
            }
        }
    }
};