class Solution {
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        
        int m = dislikes.size();
        vector<vector<int>> g(n + 1);
        vector<int> color(n + 1);
        for (int i = 0; i < m; i++) {
            g[dislikes[i][0]].push_back(dislikes[i][1]);
            g[dislikes[i][1]].push_back(dislikes[i][0]);
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                queue<int> q;
                q.push(i);
                while (!q.empty()) {
                    int t = q.front();
                    q.pop();
                    for (int j = 0; j < g[t].size(); j++) {
                        if (color[g[t][j]] == 0) {
                            color[g[t][j]] = -color[t];
                            q.push(g[t][j]);
                        } else if (color[g[t][j]] == color[t]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
};