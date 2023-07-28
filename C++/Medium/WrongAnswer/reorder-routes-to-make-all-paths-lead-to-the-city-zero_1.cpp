class Solution {
public:
    int minReorder(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> graph(n);
        for (auto& c: connections) {
            graph[c[0]].push_back(c[1]);
            graph[c[1]].push_back(-c[0]);
        }
        queue<int> q;
        q.push(0);
        int res = 0;
        vector<bool> visited(n, false);
        visited[0] = true;
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            for (int next: graph[cur]) {
                if (visited[abs(next)]) continue;
                if (next < 0) res++;
                q.push(abs(next));
                visited[abs(next)] = true;
            }
        }
        return res;
    }
};