class Solution {
public:
    int numSubseq(vector<int>& nums, int target) {
        
        int res = 0, n = nums.size(), mod = 1e9 + 7;
        sort(nums.begin(), nums.end());
        vector<int> pow2(n, 1);
        for (int i = 1; i < n; ++i)
            pow2[i] = pow2[i - 1] * 2 % mod;
        for (int i = 0, j = n - 1; i <= j; ++i) {
            while (i <= j && nums[i] + nums[j] > target) --j;
            if (i <= j) res = (res + pow2[j - i]) % mod;
        }
        return res;
    }
};