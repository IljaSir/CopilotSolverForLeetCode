class Solution {
public:
    int minimumMountainRemovals(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> f(n);
        vector<int> g(n);
        for (int i = 0; i < n; ++i) {
            f[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    f[i] = max(f[i], f[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            g[i] = 1;
            for (int j = n - 1; j > i; --j) {
                if (nums[j] < nums[i]) {
                    g[i] = max(g[i], g[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (f[i] > 1 && g[i] > 1) {
                ans = max(ans, f[i] + g[i] - 1);
            }
        }
        return n - ans;
    }
};