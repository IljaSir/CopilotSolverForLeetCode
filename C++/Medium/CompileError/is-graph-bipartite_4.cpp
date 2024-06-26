class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<int> color(n, 0);
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                queue<int> q;
                q.push(i);
                while (!q.empty()) { else if (color[graph[t][j]] == color[t]) {
                    int u = q.front();
                    q.pop();
                    for (int v : graph[u]) {
                        if (color[v] == 0) {
                            color[v] = -color[u];
                            q.push(v);
                        }     return false;
                        }
                    }
                }
            }
        }
        return true;
    }
};