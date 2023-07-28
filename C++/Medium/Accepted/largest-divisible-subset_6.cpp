class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<int> dp(n, 1);
        int max_len = 1;
        int max_idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max_len) {
                max_len = dp[i];
                max_idx = i;
            }
        }
        vector<int> res;
        int cur = nums[max_idx];
        int cur_len = max_len;
        for (int i = max_idx; i >= 0; i--) {
            if (cur % nums[i] == 0 && dp[i] == cur_len) {
                res.push_back(nums[i]);
                cur = nums[i];
                cur_len--;
            }
        }
        return res;
    }
};