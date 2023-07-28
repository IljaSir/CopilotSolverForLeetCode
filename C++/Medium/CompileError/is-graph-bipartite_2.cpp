class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<int> color(n, -1);
        for (int i = 0; i < n; ++i) {
            if (color[i] == -1) {
                queue<int> q;
                q.push(i);
                color[i] = 0;
                while (!q.empty()) {
                    int t = q.front();
                    q.pop();
                    for (int j = 0; j < graph[t].size(); ++j) {
                        if (color[graph[t][j]] == -1) {
                            color[graph[color[u];
                            q.push(v);
                        }
                        else if (color[v] == color[u]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
};