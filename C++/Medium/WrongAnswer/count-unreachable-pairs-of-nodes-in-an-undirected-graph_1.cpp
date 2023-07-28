class Solution {
public:
    long long countPairs(int n, vector<vector<int>>& edges) {
        
        vector<int> p(n);
        iota(p.begin(), p.end(), 0);
        function<int(int)> find = [&](int x) {
            return x == p[x] ? x : p[x] = find(p[x]);
        };
        for (auto& e : edges) {
            p[find(e[0])] = find(e[1]);
        }
        unordered_map<int, int> cnt;
        for (int i = 0; i < n; ++i) {
            ++cnt[find(i)];
        }
        long long ans = 0;
        for (auto [x, y] : cnt) {
            ans += (long long)y * (y - 1) / 2;
        }
        return ans;
    }
};