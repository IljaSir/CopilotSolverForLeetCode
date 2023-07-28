class Solution {
public:
    int arithmeticTriplets(vector<int>& nums, int diff) {
        
        int n = nums.size();
        vector<int> dp(n, 0);
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] - nums[j] == diff) {
                    ++dp[i];
                    ans += dp[j];
                }
            }
        }
        return ans;
    }
};