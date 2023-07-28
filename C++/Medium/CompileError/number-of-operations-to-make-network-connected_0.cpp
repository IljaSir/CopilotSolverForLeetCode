class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        
        if (connections.size() < n - 1) return -1;
        vector<int> parent(n, 0);
        for (int i = 0; i < n; ++i) parent[i] = i;
        for (auto& c : connections) {
            int p1 = find(parent, c[0]);
            int p2 = find(parent, c[1]);
            if (p1 != p2) {
                parent[p2] = p1;
                --n;
            }
        }
        return n - 1;
    }
};