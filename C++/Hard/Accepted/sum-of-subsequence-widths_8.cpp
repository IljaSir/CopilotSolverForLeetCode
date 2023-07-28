class Solution {
public:
    int sumSubseqWidths(vector<int>& nums) {
        
        int n = nums.size();
        int mod = 1e9+7;
        sort(nums.begin(), nums.end());
        long long ans = 0;
        long long pow2 = 1;
        for (int i = 0; i < n; ++i) {
            ans = (ans + (nums[i] - nums[n-1-i]) * pow2) % mod;
            pow2 = pow2 * 2 % mod;
        }
        return (ans + mod) % mod;
    }
};