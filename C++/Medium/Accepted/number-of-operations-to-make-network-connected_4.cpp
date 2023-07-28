class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        
        if (connections.size() < n - 1) return -1;
        vector<int> parent(n);
        for (int i = 0; i < n; i++) parent[i] = i;
        for (auto& c : connections) {
            int x = c[0], y = c[1];
            int px = find(parent, x);
            int py = find(parent, y);
            if (px != py) {
                parent[py] = px;
                n--;
            }
        }
        return n - 1;
    }
    int find(vector<int>& parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
};