class Solution {
public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n);
        for (auto& edge: edges) {
            graph[edge[1]].push_back(edge[0]);
        }
        vector<vector<int>> result(n);
        for (int i = 0; i < n; ++i) {
            vector<int> ancestors;
            getAncestors(graph, i, ancestors);
            result[i] = ancestors;
        }
        return result;
    }
};