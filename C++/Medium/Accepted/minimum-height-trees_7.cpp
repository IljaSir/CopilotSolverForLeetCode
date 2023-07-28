class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        
        vector<int> ret;
        if (n == 0) return ret;
        if (n == 1) {
            ret.push_back(0);
            return ret;
        }
        vector<vector<int>> graph(n);
        vector<int> degree(n, 0);
        for (auto edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) q.push(i);
        }
        while (!q.empty()) {
            ret.clear();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.front();
                q.pop();
                ret.push_back(node);
                for (int j = 0; j < graph[node].size(); j++) {
                    degree[graph[node][j]]--;
                    if (degree[graph[node][j]] == 1) q.push(graph[node][j]);
                }
            }
        }
        return ret;
    }
};