class Solution {
public:
    int minimizeSum(vector<int>& nums) {
        
        int n = nums.size();
        int res = INT_MAX;
        vector<int> dp(n, INT_MAX);
        dp[0] = 0;
        int pre = 0;
        for (int i = 1; i < n; i++) {
            int temp = dp[i - 1];
            dp[i - 1] = pre;
            pre = min(pre, temp);
            for (int j = i - 2; j >= 0; j--) {
                dp[j] = min(dp[j], abs(nums[i] - nums[j]));
            }
        }
        for (int i = 0; i < n; i++) {
            res = min(res, dp[i]);
        }
        return res;
    }
    int minDifference(vector<int>& nums) {
        if (nums.size() <= 4) {
            return 0;
        }
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int res = INT_MAX;
        res = min(res, nums[n - 1] - nums[3]);
        res = min(res, nums[n - 2] - nums[2]);
        res = min(res, nums[n - 3] - nums[1]);
        res = min(res, nums[n - 4] - nums[0]);
        return res;
    }
    int minDifference(vector<int>& nums) {
        int n = nums.size();
        if (n <= 4) {
            return 0;
        }
        sort(nums.begin(), nums.end());
        int res = INT_MAX;
        int pre = nums[n - 4] - nums[0];
        res = min(res, pre);
        for (int i = 1; i < 4; i++) {
            pre = min(pre, nums[n - 4 + i] - nums[i]);
            res = min(res, pre);
        }
        return res;
    }
    int minDifference(vector<int>& nums) {
        if (nums.size() <= 4) {
            return 0;
        }
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int res = INT_MAX;
        res = min(res, nums[n - 1] - nums[3]);
        res = min(res, nums[n - 2] - nums[2]);
        res = min(res, nums[n - 3]
    }
};