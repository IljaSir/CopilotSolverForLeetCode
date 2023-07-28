class Solution {
public:
    int sumSubseqWidths(vector<int>& nums) {
        
        const int mod = 1e9 + 7;
        sort(nums.begin(), nums.end());
        vector<int> pow2(nums.size(), 1);
        for (int i = 1; i < nums.size(); i++) {
            pow2[i] = pow2[i - 1] * 2 % mod;
        }
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            res = (res + (pow2[i] - pow2[nums.size() - 1 - i]) * nums[i]) % mod;
        }
        return (res + mod) % mod;
    }
};