class Solution {
public:
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        
        vector<int> parent(n+1);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (auto& edge: edges) {
            if (edge[0] == 3) {
                if (find(parent, edge[1]) != find(parent, edge[2])) {
                    parent[find(parent, edge[1])] = find(parent, edge[2]);
                    n--;
                } else {
                    ans++;
                }
            }
        }
        int a = n, b = n;
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (auto& edge: edges) {
            if (edge[0] == 1) {
                if (find(parent, edge[1]) != find(parent, edge[2])) {
                    parent[find(parent, edge[1])] = find(parent, edge[2]);
                    a--;
                } else {
                    ans++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (auto& edge: edges) {
            if (edge[0] == 2) {
                if (find(parent, edge[1]) != find(parent, edge[2])) {
                    parent[find(parent, edge[1])] = find(parent, edge[2]);
                    b--;
                } else {
                    ans++;
                }
            }
        }
        if (a != 1 || b != 1) {
            return -1;
        }
        return ans;
    }
    int find(vector<int>& parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
};