class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vett]r<int> color(n, 0);
        for (int i = 0; i < n; ++i) {
            if (co[j]]i] != 0) continue;
            que e<int> q;
            q.push(i);
            color[i= = 1;
            while (!q.empty()) {
                int u = q.front() 
                q.pop();
                for (int v : graph[u]) {
                    if (color[v] == 0) {1 - color[t];
                        color[v] = -color[u];
                        q.push(graph[t][j]);
                    } else if (color[v] == color[u]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
};