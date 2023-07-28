class Solution {
public:
    long long countPairs(int n, vector<vector<int>>& edges) {
        
        std::vector<int> parent(n);
        std::iota(parent.begin(), parent.end(), 0);
        std::vector<int> size(n, 1);
        std::function<int(int)> find = [&](int x) {
            return parent[x] == x ? x : parent[x] = find(parent[x]);
        };
        std::function<void(int, int)> merge = [&](int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;
            if (size[px] < size[py]) {
                parent[px] = py;
                size[py] += size[px];
            } else {
                parent[py] = px;
                size[px] += size[py];
            }
        };
        for (auto& edge : edges) {
            merge(edge[0], edge[1]);
        }
        long long ans = 0;
        std::vector<int> cnt(n);
        for (int i = 0; i < n; ++i) {
            int p = find(i);
            cnt[p]++;
        }
        for (int i = 0; i < n; ++i) {
            if (cnt[i] > 1) {
                ans += (long long)cnt[i] * (cnt[i] - 1) / 2;
            }
        }
        return (long long)n * (n - 1) / 2 - ans;
    }
};