class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        
        int m = connections.size();
        if (m < n - 1) {
            return -1;
        }
        vector<int> parent(n);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (auto &c : connections) {
            int a = c[0], b = c[1];
            if (find(a, parent) != find(b, parent)) {
                parent[find(a, parent)] = find(b, parent);
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                cnt++;
            }
        }
        return cnt - 1;
    }
    int find(int x, vector<int> &parent) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }
};