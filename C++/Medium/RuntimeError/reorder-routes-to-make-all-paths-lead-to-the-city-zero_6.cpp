class Solution {
public:
    int minReorder(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> graph(n);
        for (auto& edge : connections) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(-edge[0]);
        }
        int res = 0;
        dfs(graph, 0, res);
        return res;
    }
    void dfs(vector<vector<int>>& graph, int cur, int& res) {
        for (auto next : graph[cur]) {
            if (next == -1) continue;
            if (next < 0) {
                dfs(graph, -next, res);
                res++;
            } else {
                dfs(graph, next, res);
            }
        }
    }
};