class Solution {
public:
    int sumSubseqWidths(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        long long res = 0, c = 1;
        const int MOD = 1e9 + 7;
        for (int i = 0; i < n; i++) {
            res = (res + nums[i] * c - nums[n - 1 - i] * c) % MOD;
            c = c * 2 % MOD;
        }
        return (res + MOD) % MOD;
    }
};