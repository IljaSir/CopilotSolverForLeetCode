class Solution {
public:
    int numSubseq(vector<int>& nums, int target) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int res = 0, mod = 1e9 + 7;
        vector<int> pow2(n, 1);
        for (int i = 1; i < n; ++i) pow2[i] = pow2[i - 1] * 2 % mod;
        int j = n - 1;
        for (int i = 0; i <= j; ++i) {
            while (j >= i && nums[i] + nums[j] > target) --j;
            if (j < i) break;
            res = (res + pow2[j - i]) % mod;
        }
        return res;
    }
};