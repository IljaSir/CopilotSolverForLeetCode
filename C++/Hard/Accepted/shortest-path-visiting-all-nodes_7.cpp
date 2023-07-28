class Solution {
public:
    int shortestPathLength(vector<vector<int>>& graph) {
        
        int n = graph.size();
        int ans = 0;
        queue<pair<int, int>> q;
        vector<vector<bool>> visited(n, vector<bool>(1 << n, false));
        for (int i = 0; i < n; i++) {
            q.push({i, 1 << i});
            visited[i][1 << i] = true;
        }
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto [node, state] = q.front();
                q.pop();
                if (state == (1 << n) - 1) {
                    return ans;
                }
                for (int next : graph[node]) {
                    int nextState = state | (1 << next);
                    if (visited[next][nextState]) {
                        continue;
                    }
                    q.push({next, nextState});
                    visited[next][nextState] = true;
                }
            }
            ans++;
        }
        return ans;
    }
};