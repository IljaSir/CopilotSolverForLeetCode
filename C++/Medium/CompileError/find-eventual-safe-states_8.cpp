class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<int> safe;
        vector<int> state(n, 0);
        for (int i = 0; i < n; ++i) {
            if (dfs(graph, i, state)) {
                safe.push_back(i);
            }
        }
        return safe;
    }
};