class Solution {
public:
    int sumSubseqWidths(vector<int>& nums) {
        
        const int MOD = 1000000007;
        sort(nums.begin(), nums.end());
        vector<int> pow2(nums.size(), 1);
        for (int i = 1; i < nums.size(); ++i) {
            pow2[i] = (pow2[i - 1] << 1) % MOD;
        }
        int ans = 0;
        for (int i = 0; i < nums.size(); ++i) {
            ans = (ans + (pow2[i] - pow2[nums.size() - i - 1]) * nums[i]) % MOD;
        }
        return ans;
    }
};