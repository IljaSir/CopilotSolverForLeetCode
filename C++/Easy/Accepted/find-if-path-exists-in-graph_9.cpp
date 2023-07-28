class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        
        vector<vector<int>> g(n);
        for(auto &e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> visited(n);
        queue<int> q;
        q.push(source);
        visited[source] = 1;
        while (!q.empty()) {
            int x = q.front();
            q.pop();
            if (x == destination) {
                return true;
            }
            for (int y : g[x]) {
                if (!visited[y]) {
                    visited[y] = 1;
                    q.push(y);
                }
            }
        }
        return false;
    }
};