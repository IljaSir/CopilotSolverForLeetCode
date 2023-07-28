class Solution {
public:
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<int> count(n, 1);
        vector<int> res(n, 0);
        dfs(graph, 0, -1, count, res);
        dfs2(graph, 0, -1, count, res);
        return res;
    }
};