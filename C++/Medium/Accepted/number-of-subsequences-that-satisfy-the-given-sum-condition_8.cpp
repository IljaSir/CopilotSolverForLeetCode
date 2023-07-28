class Solution {
public:
    int numSubseq(vector<int>& nums, int target) {
        
        int mod = 1e9 + 7;
        sort(nums.begin(), nums.end());
        long long ans = 0;
        int n = nums.size();
        vector<long long> pow2(n, 1);
        for (int i = 1; i < n; ++i) {
            pow2[i] = pow2[i - 1] * 2 % mod;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                --r;
            } else {
                ans = (ans + pow2[r - l]) % mod;
                ++l;
            }
        }
        return ans;
    }
};