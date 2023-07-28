class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        
        if (connections.size() < n - 1) return -1;
        vector<int> p(n);
        iota(p.begin(), p.end(), 0);
        for (auto& c : connections) {
            int x = find(p, c[0]), y = find(p, c[1]);
            if (x != y) p[x] = y;
        }
        unordered_set<int> s;
        for (int i = 0; i < n; ++i) s.insert(find(p, i));
        return s.size() - 1;
    }
};