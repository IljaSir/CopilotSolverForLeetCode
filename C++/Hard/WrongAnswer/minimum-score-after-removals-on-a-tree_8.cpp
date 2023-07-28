class Solution {
public:
    int minimumScore(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<int> f(n);
        iota(f.begin(), f.end(), 0);
        function<int(int)> find = [&](int x) {
            return x == f[x] ? x : f[x] = find(f[x]);
        };
        for (auto& e : edges) {
            int x = find(e[0]), y = find(e[1]);
            if (x != y) f[x] = y;
        }
        vector<int> id(n);
        for (int i = 0; i < n; i++) id[find(i)] = i;
        vector<int> xorv(n);
        for (int i = 0; i < n; i++) xorv[id[i]] ^= nums[i];
        vector<int> sz(n);
        for (int i = 0; i < n; i++) sz[id[i]]++;
        int ans = INT_MAX;
        for (auto& e : edges) {
            int x = find(e[0]), y = find(e[1]);
            if (sz[x] > sz[y]) swap(x, y);
            if (sz[x] > 1) {
                int tmp = xorv[y];
                xorv[y] ^= xorv[x];
                ans = min(ans, max(xorv[y], tmp) - min(xorv[y], tmp));
                xorv[y] = tmp;
            }
        }
        return ans;
    }
};