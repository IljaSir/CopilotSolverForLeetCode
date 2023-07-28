class Solution {
public:
    int numSubseq(vector<int>& nums, int target) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int64_t res = 0, mod = 1e9+7;
        vector<int64_t> power(n, 1);
        for (int i = 1; i < n; ++i) {
            power[i] = power[i-1] * 2 % mod;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                --r;
            } else {
                res = (res + power[r-l]) % mod;
                ++l;
            }
        }
        return res;
    }
};