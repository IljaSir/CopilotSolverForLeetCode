class Solution {
public:
    int jump(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> dp(n, 0);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minJump = INT_MAX;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= i - j) {
                    minJump = min(minJump, dp[j]);
                }
            }
            dp[i] = minJump + 1;
        }
        return dp[n - 1];
    }
};