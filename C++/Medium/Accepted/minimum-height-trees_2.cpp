class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        
        vector<int> res;
        if (n == 1) {
            res.push_back(0);
            return res;
        }
        vector<int> degree(n, 0);
        vector<vector<int>> graph(n, vector<int>());
        for (int i = 0; i < edges.size(); ++i) {
            ++degree[edges[i][0]];
            ++degree[edges[i][1]];
            graph[edges[i][0]].push_back(edges[i][1]);
            graph[edges[i][1]].push_back(edges[i][0]);
        }
        queue<int> q;
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            res.clear();
            int k = q.size();
            for (int i = 0; i < k; ++i) {
                int t = q.front();
                q.pop();
                res.push_back(t);
                for (int j = 0; j < graph[t].size(); ++j) {
                    --degree[graph[t][j]];
                    if (degree[graph[t][j]] == 1) {
                        q.push(graph[t][j]);
                    }
                }
            }
        }
        return res;
    }
};