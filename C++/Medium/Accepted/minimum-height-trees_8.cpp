class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        
        if (n == 1) return {0};
        vector<int> ans;
        vector<int> degree(n);
        vector<vector<int>> graph(n);
        for (auto& edge : edges) {
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
            ans.clear();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.front();
                q.pop();
                ans.push_back(node);
                for (int j = 0; j < graph[node].size(); j++) {
                    if (--degree[graph[node][j]] == 1) {
                        q.push(graph[node][j]);
                    }
                }
            }
        }
        return ans;
    }
};