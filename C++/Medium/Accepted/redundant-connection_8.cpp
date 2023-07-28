class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        
        int n = edges.size();
        vector<int> p(n+1, 0);
        for (int i = 1; i <= n; ++i) p[i] = i;
        for (auto edge : edges) {
            int x = edge[0], y = edge[1];
            if (find(p, x) == find(p, y)) return edge;
            p[find(p, x)] = find(p, y);
        }
        return {};
    }
    int find(vector<int> &p, int x) {
        if (p[x] != x) p[x] = find(p, p[x]);
        return p[x];
    }
};