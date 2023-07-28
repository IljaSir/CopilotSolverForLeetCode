class Solution {
public:
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {
        
        int n = edges.size();
        vector<int> indegree(n + 1, 0);
        for (auto& e : edges) {
            ++indegree[e[1]];
        }

        vector<int> ans1, ans2;
        for (int i = n - 1; i >= 0; --i) {
            if (indegree[edges[i][1]] == 2) {
                ans1 = edges[i];
            }
        }
        vector<int> parent(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            parent[i] = i;
        }
        for (auto& e : edges) {
            if (e == ans1) {
                continue;
            }
            int u = e[0];
            int v = e[1];
            if (find(parent, u) == v) {
                ans2 = e;
            } else {
                parent[v] = u;
            }
        }
        if (ans2.empty()) {
            return ans1;
        }
        if (ans1.empty()) {
            return ans2;
        }
        for (auto& e : edges) {
            if (e[1] == ans1[1]) {
                return e;
            }
        }
        return {};
    }
};