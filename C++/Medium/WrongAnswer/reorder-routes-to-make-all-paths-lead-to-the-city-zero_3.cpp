class Solution {
public:
    int minReorder(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> graph(n);
        for (auto& c: connections) {
            graph[c[0]].push_back(c[1]);
            graph[c[1]].push_back(-c[0]);
        }
        int ans = 0;
        vector<bool> visited(n);
        queue<int> q;
        q.push(0);
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            if (visited[u]) continue;
            visited[u] = true;
            for (int v: graph[u]) {
                if (v < 0) {
                    v = -v;
                    ans++;
                }
                q.push(v);
            }
        }
        return ans;
    }
};