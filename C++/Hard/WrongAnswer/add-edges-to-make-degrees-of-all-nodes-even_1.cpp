class Solution {
public:
    bool isPossible(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
            graph[e[0] - 1].push_back(e[1] - 1);
            graph[e[1] - 1].push_back(e[0] - 1);
        }
        vector<int> degrees(n);
        for (int i = 0; i < n; ++i) {
            degrees[i] = graph[i].size();
        }
        vector<int> colors(n);
        int color = 1;
        for (int i = 0; i < n; ++i) {
            if (colors[i] == 0) {
                if (!dfs(graph, colors, color, i)) {
                    return false;
                }
                color++;
            }
        }
        int oddDegree = 0;
        for (int i = 0; i < n; ++i) {
            if (degrees[i] % 2 == 1) {
                oddDegree++;
            }
        }
        return oddDegree <= 2;
    }
    bool dfs(vector<vector<int>>& graph, vector<int>& colors, int color, int node) {
        colors[node] = color;
        for (int i = 0; i < graph[node].size(); ++i) {
            int neighbor = graph[node][i];
            if (colors[neighbor] == color) {
                return false;
            }
            if (colors[neighbor] == 0 && !dfs(graph, colors, color, neighbor)) {
                return false;
            }
        }
        return true;
    }
};