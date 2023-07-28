class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<int> color(n, 0);
        for (int i = 0; i < n; ++i) {
            if (color[i] != 0) continue;
            color[i] = 1;
            queue<int> q;
            q.push(i);
            while (!q.empty()) {
                int t = q.front();
                q.pop();
                for (int j : graph[t]) {
                    if (color[j] == 0) {
                        color[j] = -color[t];
                        q.push(j);
                    } else if (color[j] == color[t]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
};