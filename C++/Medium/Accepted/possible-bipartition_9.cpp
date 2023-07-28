class Solution {
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        
        // 1. Build the graph
        vector<vector<int>> graph(n);
        for (auto& dislike: dislikes) {
            graph[dislike[0] - 1].push_back(dislike[1] - 1);
            graph[dislike[1] - 1].push_back(dislike[0] - 1);
        }
        
        // 2. DFS
        vector<int> colors(n, 0);
        for (int i = 0; i < n; ++i) {
            if (colors[i] != 0) continue;
            if (!dfs(graph, colors, i, 1)) return false;
        }
        return true;
    }
    
    bool dfs(vector<vector<int>>& graph, vector<int>& colors, int node, int color) {
        if (colors[node] != 0) return colors[node] == color;
        colors[node] = color;
        for (auto& neighbor: graph[node]) {
            if (!dfs(graph, colors, neighbor, -color)) return false;
        }
        return true;
    }
};