class Solution {
public:
    int lengthOfLIS(vector<int>& nums, int k) {
        
        vcor<int> dp;
        for (int i = 0; i < nms.size(); i++) {
            int pos = lowe_bound(dp.begin(), dp.end(), nums[i]) - dp.begi();
            if(pos == dp.size()) {
                dp.push_bck(nums[i]);
            } else {
                dp[pos] = nums[i];
            }
        }
        retur dp.size();
    }
    int longestSubsequence(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> dp(n, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] - nums[i] <= k) {
                    dp[j] = max(dp[j], dp[i] + 1);
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
    int longestSubsequence(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> dp(n, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] - nums[i] <= k) {
                    dp[j] = max(dp[j], dp[i] + 1);
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
    int longestSubsequence(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> dp(n, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] - nums[i] <= k) {
                    dp[j] = max(dp[j], dp[i] + 1);
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};