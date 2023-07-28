class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        
        if (connections.size() < n - 1) return -1;
        vector<int> parent(n);
        iota(parent.begin(), parent.end(), 0);
        int res = n;
        for (auto& c : connections) {
            int p1 = find(parent, c[0]);
            int p2 = find(parent, c[1]);
            if (p1 != p2) {
                parent[p1] = p2;
                --res;
            }
        }
        return res - 1;
    }
};