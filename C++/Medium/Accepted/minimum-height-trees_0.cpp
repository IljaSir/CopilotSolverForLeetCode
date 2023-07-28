class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        
        vector<int> res;
        if (n == 1) {
            res.push_back(0);
            return res;
        }
        vector<vector<int>> graph(n);
        vector<int> degree(n, 0);
        for (auto edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            res.clear();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.front();
                q.pop();
                res.push_back(node);
                for (int neighbor : graph[node]) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        q.push(neighbor);
                    }
                }
            }
        }
        return res;
    }
};