class Solution {
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        
        vector<vector<int>> graph(n+1);
        for (auto d : dislikes) {
            graph[d[0]].push_back(d[1]);
            graph[d[1]].push_back(d[0]);
        }
        vector<int> color(n+1, 0);
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                queue<int> q;
                q.push(i);
                while (!q.empty()) {
                    int cur = q.front();
                    q.pop();
                    for (int j = 0; j < graph[cur].size(); j++) {
                        int next = graph[cur][j];
                        if (color[next] == color[cur]) {
                            return false;
                        }
                        if (color[next] == 0) {
                            color[next] = -color[cur];
                            q.push(next);
                        }
                    }
                }
            }
        }
        return true;
    }
};