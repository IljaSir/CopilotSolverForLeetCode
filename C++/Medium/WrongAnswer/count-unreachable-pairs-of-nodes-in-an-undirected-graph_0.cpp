class Solution {
public:
    long long countPairs(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<int> visited(n);
        long long res = 0;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                int cnt = 0;
                dfs(graph, visited, i, cnt);
                res += (long long)cnt * (cnt - 1) / 2;
            }
        }
        return res;
    }
    
    void dfs(vector<vector<int>>& graph, vector<int>& visited, int i, int& cnt) {
        visited[i] = 1;
        ++cnt;
        for (int j : graph[i]) {
            if (!visited[j]) {
                dfs(graph, visited, j, cnt);
            }
        }
    }
};