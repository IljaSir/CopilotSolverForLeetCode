class Solution {
public:
    int sumOfFlooredPairs(vector<int>& nums) {
        
        int n = nums.size();
        const int MOD = 1e9 + 7;
        sort(nums.begin(), nums.end());
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int j = i, k = i;
            while (k < n && nums[i] == nums[k]) {
                ++k;
            }
            while (j < n) {
                int l = j, r = n;
                while (l < r) {
                    int m = (l + r) / 2;
                    if (nums[m] < nums[i] * 2) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                int t = l - j;
                res = (res + (long long)nums[i] * t % MOD) % MOD;
                res = (res + (long long)(t - k + j) * (k - j) / 2 % MOD) % MOD;
                j = l;
            }
            i = k - 1;
        }
        return res;
    }
};