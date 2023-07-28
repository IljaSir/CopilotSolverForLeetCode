class Solution {
public:
    int magnificentSets(int n, vector<vector<int>>& edges) {
        
        vector<int> a(n);
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        for (auto& edge : edges) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            int p = find(a, x);
            int q = find(a, y);
            a[p] = q;
        }
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            int p = find(a, i);
            m[p]++;
        }
        int res = 0;
        for (auto& kv : m) {
            res = max(res, kv.second);
        };
    }
};