class Solution {
public:
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        
        vector<int> parent(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            parent[i] = i;
        }
        int result = edges.size();
        for (auto& edge : edges) {
            if (edge[0] == 3) {
                if (find(parent, edge[1]) != find(parent, edge[2])) {
                    unite(parent, edge[1], edge[2]);
                    --result;
                }
            }
        }
        vector<int> parentA(parent);
        for (auto& edge : edges) {
            if (edge[0] == 1) {
                if (find(parentA, edge[1]) != find(parentA, edge[2])) {
                    unite(parentA, edge[1], edge[2]);
                    --result;
                }
            }
        }
        vector<int> parentB(parent);
        for (auto& edge : edges) {
            if (edge[0] == 2) {
                if (find(parentB, edge[1]) != find(parentB, edge[2])) {
                    unite(parentB, edge[1], edge[2]);
                    --result;
                }
            }
        }
        int root = find(parentA, 1);
        for (int i = 2; i <= n; ++i) {
            if (find(parentA, i) != root) {
                return -1;
            }
        }
        root = find(parentB, 1);
        for (int i = 2; i <= n; ++i) {
            if (find(parentB, i) != root) {
                return -1;
            }
        }
        return result;
    }
};