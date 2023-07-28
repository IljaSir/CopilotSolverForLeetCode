class Solution {
public:
    int maximumInvitations(vector<int>& favorite) {
        
        int n = favorite.size();
        vector<int> visited(n, 0);
        vector<vector<int>> graph(n);
        for (int i = 0; i < n; ++i) {
            graph[favorite[i]].push_back(i);
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (visited[i] == 0) {
                res += dfs(graph, visited, i);
            }
        }
        return res;
    }
};