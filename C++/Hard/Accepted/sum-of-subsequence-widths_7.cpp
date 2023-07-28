class Solution {
public:
    int sumSubseqWidths(vector<int>& nums) {
        
        int n = nums.size();
        int mod = 1000000007;
        sort(nums.begin(), nums.end());
        long long ans = 0;
        long long pow = 1;
        for (int i = 0; i < n; i++) {
            ans = (ans + nums[i] * pow - nums[n - i - 1] * pow) % mod;
            pow = pow * 2 % mod;
        }
        return (ans + mod) % mod;
    }
};