class Solution {
public:
    int numSquarefulPerms(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> g(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int x = nums[i] + nums[j];
                int y = sqrt(x);
                g[i][j] = (y * y == x);
            }
        }
        vector<int> f(1 << n);
        f[0] = 1;
        for (int mask = 1; mask < (1 << n); ++mask) {
            int bits = __builtin_popcount(mask);
            vector<int> last(n, -1);
            for (int i = 0; i < n; ++i) {
                if (mask & (1 << i)) {
                    if (last[nums[i]] >= 0) {
                        if (g[last[nums[i]]][i]) {
                            f[mask] += f[mask ^ (1 << i)];
                        }
                    }
                    last[nums[i]] = i;
                }
            }
        }
        return f[(1 << n) - 1];
    }
};