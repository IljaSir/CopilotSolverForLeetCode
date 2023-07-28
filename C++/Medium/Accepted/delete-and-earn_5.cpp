class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> count(10001);
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        vector<int> dp(10001);
        dp[1] = count[1];
        for (int i = 2; i <= 10000; i++) {
            dp[i] = max(dp[i - 1], dp[i - 2] + count[i] * i);
        }
        return dp[10000];
    }
};