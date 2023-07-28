class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        
        if (connections.size() < n - 1) return -1;
        vector<int> parent(n, 0);
        for (int i = 0; i < n; i++) parent[i] = i;
        for (auto &c : connections) {
            int x = find(parent, c[0]);
            int y = find(parent, c[1]);
            parent[x] = y;
        }
        unordered_set<int> s;
        for (int i = 0; i < n; i++) s.insert(find(parent, i));
        return s.size() - 1;
    }
};