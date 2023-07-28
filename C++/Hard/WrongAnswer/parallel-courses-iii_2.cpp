class Solution {
public:
    int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) {
        
        vector<vector<int>> graph(n);
        vector<int> indeg(n);
        for (auto& edge : relations) {
            graph[edge[0] - 1].push_back(edge[1] - 1);
            indeg[edge[1] - 1]++;
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.push(i);
            }
        }
        vector<int> res(n);
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v : graph[u]) {
                indeg[v]--;
                res[v] = max(res[v], res[u] + time[u]);
                if (indeg[v] == 0) {
                    q.push(v);
                }
            }
        }
        return *max_element(res.begin(), res.end()) + *max_element(time.begin(), time.end());
    }
};