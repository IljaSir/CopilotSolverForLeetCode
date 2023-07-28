class Solution {
public:
    int minChanges(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<vector<int>> f(k+1, vector<int>(1024, n));
        f[0][0] = 0;
        for (int i = 0; i < k; ++i) {
            vector<int> cnt(1024, 0);
            int size = 0;
            for (int j = i; j < n; j += k) {
                ++cnt[nums[j]];
                ++size;
            }
            int tot = accumulate(cnt.begin(), cnt.end(), 0);
            vector<int> g(1024, n);
            for (int mask = 0; mask < 1024; ++mask) {
                for (int x = 0; x < 1024; ++x) {
                    g[mask] = min(g[mask], f[i][x] + tot - cnt[x ^ mask]);
                }
            }
            f[i + 1] = g;
        }
        return f[k][0];
    }
};