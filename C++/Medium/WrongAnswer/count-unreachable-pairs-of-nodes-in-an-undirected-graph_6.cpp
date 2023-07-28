class Solution {
public:
    long long countPairs(int n, vector<vector<int>>& edges) {
        
        vector<int> rank(n);
        vector<int> parent(n);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.size(); i++) {
            int x = find(parent, edges[i][0]);
            int y = find(parent, edges[i][1]);
            if (x != y) {
                if (rank[x] > rank[y]) {
                    parent[y] = x;
                } else if (rank[x] < rank[y]) {
                    parent[x] = y;
                } else {
                    parent[x] = y;
                    rank[y]++;
                }
            }
        }
        long long ans = 0;
        vector<int> cnt(n);
        for (int i = 0; i < n; i++) {
            cnt[find(parent, i)]++;
        }
        for (int i = 0; i < n; i++) {
            ans += 1LL * cnt[i] * (cnt[i] - 1) / 2;
        }
        return ans;
    }
    int find(vector<int>& parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
};