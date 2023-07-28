class Solution {
public:
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        
        vector<int> parent(n+1, 0);
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }
        int ans = 0;
        for (auto& e : edges) {
            if (e[0] == 3) {
                if (find(parent, e[1]) == find(parent, e[2])) {
                    ans++;
                } else {
                    merge(parent, e[1], e[2]);
                }
            }
        }
        int A = 0, B = 0;
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }
        for (auto& e : edges) {
            if (e[0] == 1) {
                if (find(parent, e[1]) == find(parent, e[2])) {
                    ans++;
                    A++;
                } else {
                    merge(parent, e[1], e[2]);
                }
            }
        }
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }
        for (auto& e : edges) {
            if (e[0] == 2) {
                if (find(parent, e[1]) == find(parent, e[2])) {
                    ans++;
                    B++;
                } else {
                    merge(parent, e[1], e[2]);
                }
            }
        }
        if (A+B == n-1) {
            return ans;
        }
        return -1;
    }
    int find(vector<int>& parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    void merge(vector<int>& parent, int i, int j) {
        int pi = find(parent, i);
        int pj = find(parent, j);
        if (pi != pj) {
            parent[pi] = pj;
        }
    }
};