class Solution {
public:
    int minChanges(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> f(1024, n);
        f[0] = 0;
        for (int i = 0; i < k; ++i) {
            int cnt[1024] = {0};
            int size = 0;
            for (int j = i; j < n; j += k) {
                ++cnt[nums[j]];
                ++size;
            }
            int t2min = *min_element(f.begin(), f.end());
            vector<int> g(1024, t2min);
            for (int mask = 0; mask < 1024; ++mask) {
                for (int x = 0; x < 1024; ++x) {
                    g[mask] = min(g[mask], f[x] + size - cnt[x ^ mask]);
                }
            }
            f = g;
        }
        return f[0];
    }
};