class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<int> color(n, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                queue<int> q;
                q.push(i);
                color[i] = 0;
                while (!q.empty()) {
                    int node = q.front();
                    q.pop();
                    for (int v : graph[node]) {
                        if (color[v] == -1) {
                            q.push(v);
                            color[v] = color[node] ^ 1;
                        } else if (color[v] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
};