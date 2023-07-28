class Solution {
public:
    int countSpecialSubsequences(vector<int>& nums) {
        
        long long f[3] = {0};
        int mod = 1e9 + 7;
        for (int i = 0; i < nums.size(); i++) {
            f[nums[i]] = (f[nums[i]] + f[nums[i] - 1] + 1) % mod;
        }
        return f[2];
    }
};