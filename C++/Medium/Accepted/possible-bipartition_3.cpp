class Solution {
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        
        vector<vector<int>> graph(n);
        for (auto& d: dislikes) {
            graph[d[0] - 1].push_back(d[1] - 1);
            graph[d[1] - 1].push_back(d[0] - 1);
        }
        vector<int> colors(n, -1);
        for (int i = 0; i < n; ++i) {
            if (colors[i] == -1) {
                colors[i] = 0;
                queue<int> q;
                q.push(i);
                while (!q.empty()) {
                    int t = q.front();
                    q.pop();
                    for (int j = 0; j < graph[t].size(); ++j) {
                        if (colors[graph[t][j]] == -1) {
                            colors[graph[t][j]] = 1 - colors[t];
                            q.push(graph[t][j]);
                        } else if (colors[graph[t][j]] == colors[t]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
};