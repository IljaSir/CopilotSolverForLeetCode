class Solution {
public:
    int numSubseq(vector<int>& nums, int target) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        vector<int> dp(n, 1);
        for(int i = 1; i < n; ++i)
            dp[i] = (dp[i - 1] * 2) % 1000000007;
        int ans = 0;
        for(int i = 0, j = n - 1; i <= j; ++i) {
            while(i <= j && nums[i] + nums[j] > target) --j;
            if(i <= j) {
                ans += dp[j - i];
                ans %= 1000000007;
            }
        }
        return ans;
    }
};