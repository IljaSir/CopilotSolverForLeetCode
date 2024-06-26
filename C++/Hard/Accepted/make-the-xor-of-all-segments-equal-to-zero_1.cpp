class Solution {
public:
    int minChanges(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> f(1 << 10, n);
        f[0] = 0;
        for (int i = 0; i < k; ++i) {
            unordered_map<int, int> cnt;
            int size = 0;
            for (int j = i; j < n; j += k) {
                ++cnt[nums[j]];
                ++size;
            }
            int t2min = *min_element(f.begin(), f.end());
            vector<int> g(1 << 10, t2min);
            for (int mask = 0; mask < (1 << 10); ++mask) {
                for (auto& [x, countx]: cnt) {
                    g[mask] = min(g[mask], f[mask ^ x] - countx);
                }
            }
            for (auto& x: g) {
                x += size;
            }
            f = g;
        }
        return f[0];
    }
};