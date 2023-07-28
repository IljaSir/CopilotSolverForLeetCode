class Solution {
public:
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        
        vector<int> parent(n + 1, 0);
        vector<int> parent2(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            parent[i] = i;
            parent2[i] = i;
        }
        int ans = 0;
        int cnt = 0;
        for (auto &edge : edges) {
            if (edge[0] == 3) {
                if (Union(parent, edge[1], edge[2])) {
                    cnt++;
                } else {
                    ans++;
                }
                if (Union(parent2, edge[1], edge[2])) {
                    cnt++;
                } else {
                    ans++;
                }
            }
        }
        for (auto &edge : edges) {
            if (edge[0] == 1) {
                if (Union(parent, edge[1], edge[2])) {
                    cnt++;
                } else {
                    ans++;
                }
            }
            if (edge[0] == 2) {
                if (Union(parent2, edge[1], edge[2])) {
                    cnt++;
                } else {
                    ans++;
                }
            }
        }
        if (cnt == n - 1) {
            return ans;
        }
        return -1;
    }
    int find(vector<int> &parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    bool Union(vector<int> &parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px == py) {
            return false;
        }
        parent[px] = py;
        return true;
    }
};