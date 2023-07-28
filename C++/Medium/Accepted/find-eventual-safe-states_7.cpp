class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<int> degree(n, 0);
        vector<vector<int>> edges(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                edges[graph[i][j]].push_back(i);
                degree[i]++;
            }
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                q.push(i);
            }
        }
        vector<int> res;
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            res.push_back(u);
            for (int v : edges[u]) {
                degree[v]--;
                if (degree[v] == 0) {
                    q.push(v);
                }
            }
        }
        sort(res.begin(), res.end());
        return res;
    }
};