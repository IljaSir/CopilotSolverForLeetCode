class Solution {
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        
        vector<vector<int>> graph(n);
        for (auto& d : dislikes) {
            graph[d[0] - 1].push_back(d[1] - 1);
            graph[d[1] - 1].push_back(d[0] - 1);
        }
        vector<int> color(n, 0);
        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;
            stack<int> s;
            s.push(i);
            color[i] = 1;
            while (!s.empty()) {
                int cur = s.top();
                s.pop();
                for (int j = 0; j < graph[cur].size(); j++) {
                    if (color[graph[cur][j]] == color[cur]) {
                        return false;
                    }
                    if (color[graph[cur][j]] == 0) {
                        s.push(graph[cur][j]);
                        color[graph[cur][j]] = -color[cur];
                    }
                }
            }
        }
        return true;
    }
};