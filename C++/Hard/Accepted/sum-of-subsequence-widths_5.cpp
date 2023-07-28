class Solution {
public:
    int sumSubseqWidths(vector<int>& nums) {
        
        const int MOD = 1e9 + 7;
        sort(nums.begin(), nums.end());
        int n = nums.size();
        long long ans = 0;
        long long p = 1;
        for (int i = 0; i < n; i++) {
            ans = (ans + nums[i] * p - nums[n - 1 - i] * p) % MOD;
            p = p * 2 % MOD;
        }
        return (ans + MOD) % MOD;
    }
};