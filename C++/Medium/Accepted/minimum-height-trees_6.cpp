class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        
        vector<int> res;
        if (n == 1) {
            res.push_back(0);
            return res;
        }
        vector<unordered_set<int>> graph(n);
        for (auto &edge : edges) {
            graph[edge[0]].insert(edge[1]);
            graph[edge[1]].insert(edge[0]);
        }
        queue<int> q;
        for (int i = 0; i < n; ++i) {
            if (graph[i].size() == 1) {
                q.push(i);
            }
        }
        while (n > 2) {
            int size = q.size();
            n -= size;
            for (int i = 0; i < size; ++i) {
                int t = q.front();
                q.pop();
                for (auto a : graph[t]) {
                    graph[a].erase(t);
                    if (graph[a].size() == 1) {
                        q.push(a);
                    }
                }
            }
        }
        while (!q.empty()) {
            res.push_back(q.front());
            q.pop();
        }
        return res;
    }
};