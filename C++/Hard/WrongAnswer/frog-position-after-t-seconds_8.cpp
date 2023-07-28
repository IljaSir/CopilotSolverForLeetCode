class Solution {
public:
    double frogPosition(int n, vector<vector<int>>& edges, int t, int target) {
        
        int i, j, k, u, v, w, x, y, z;
        int m = edges.size();
        vector<vector<int>> g(n + 1);
        for (i = 0; i < m; i++) {
            u = edges[i][0];
            v = edges[i][1];
            g[u].push_back(v);
            g[v].push_back(u);
        }
        vector<int> visited(n + 1);
        vector<int> q;
        q.push_back(1);
        visited[1] = 1;
        double ans = 1.0;
        for (i = 0; i < t; i++) {
            vector<int> next;
            for (j = 0; j < q.size(); j++) {
                x = q[j];
                y = 0;
                for (k = 0; k < g[x].size(); k++) {
                    if (visited[g[x][k]]) {
                        y++;
                    }
                }
                for (k = 0; k < g[x].size(); k++) {
                    if (!visited[g[x][k]]) {
                        visited[g[x][k]] = 1;
                        next.push_back(g[x][k]);
                        ans = ans * 1.0 / (g[x].size() - y);
                    }
                }
            }
            q = next;
        }
        for (i = 0; i < q.size(); i++) {
            if (q[i] == target) {
                return ans;
            }
        }
        return 0.0;
    }
};