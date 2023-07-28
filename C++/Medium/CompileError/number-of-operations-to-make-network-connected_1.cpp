class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        
        if (connections.size() < n - 1) return -1;
        vector<int> parent(n);
        for (int i = 0; i < n; ++i) parent[i] = i;
        for (auto& c : connections) {
            int r1 = find(parent, c[0]);
            int r2 = find(parent, c[1]);
            if (r1 != r2) parent[r1] = r2;
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (parent[i] == i) ++res;
        }
        return res - 1;
    }
};