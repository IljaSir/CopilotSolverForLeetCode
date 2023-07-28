class Solution {
public:
    long long countPairs(int n, vector<vector<int>>& edges) {
        
        vector<int> parent(n);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (auto &edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int pu = find(u, parent);
            int pv = find(v, parent);
            if (pu != pv) {
                parent[pu] = pv;
            }
        }
        vector<int> size(n);
        for (int i = 0; i < n; i++) {
            int p = find(i, parent);
            size[p]++;
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            if (size[i] > 1) {
                ans += (long long)size[i] * (size[i] - 1) / 2;
            }
        }
        return (long long)n * (n - 1) / 2 - ans;
    }
};