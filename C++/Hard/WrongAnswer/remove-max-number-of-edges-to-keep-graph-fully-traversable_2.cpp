class Solution {
public:
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        
        vector<int> parent(n + 1);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int res = 0;
        for (auto& edge : edges) {
            if (edge[0] == 3) {
                if (find(parent, edge[1]) == find(parent, edge[2])) {
                    res++;
                } else {
                    merge(parent, edge[1], edge[2]);
                }
            }
        }
        int aParent = find(parent, 1);
        int bParent = find(parent, 1);
        for (auto& edge : edges) {
            if (edge[0] == 1) {
                if (find(parent, edge[1]) == find(parent, edge[2])) {
                    res++;
                } else {
                    merge(parent, edge[1], edge[2]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (find(parent, i) != aParent) {
                return -1;
            }
        }
        for (auto& edge : edges) {
            if (edge[0] == 2) {
                if (find(parent, edge[1]) == find(parent, edge[2])) {
                    res++;
                } else {
                    merge(parent, edge[1], edge[2]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (find(parent, i) != bParent) {
                return -1;
            }
        }
        return res;
    }
    int find(vector<int>& parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    void merge(vector<int>& parent, int x, int y) {
        int xParent = find(parent, x);
        int yParent = find(parent, y);
        if (xParent != yParent) {
            parent[xParent] = yParent;
        }
    }
};