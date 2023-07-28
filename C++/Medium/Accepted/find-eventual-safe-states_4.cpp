class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<int> res;
        vector<int> color(n, 0);
        for (int i = 0; i < n; i++) {
            if (safe(graph, color, i)) {
                res.push_back(i);
            }
        }
        return res;
    }
    bool safe(vector<vector<int>>& graph, vector<int> &color, int x) {
        if (color[x] > 0) {
            return color[x] == 2;
        }
        color[x] = 1;
        for (int y : graph[x]) {
            if (!safe(graph, color, y)) {
                return false;
            }
        }
        color[x] = 2;
        return true;
    }
};