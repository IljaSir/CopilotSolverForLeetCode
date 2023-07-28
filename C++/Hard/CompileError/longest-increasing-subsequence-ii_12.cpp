class Solution {
public:
    int lengthOfLIS(vector<int>& nums, int k) {
        
        int len = nums.size();
        if (len <= 1) return len;
        vector<int> dp(len, 1);
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] - nums[j] <= k) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < len; i++) {or<int>& nums, int k) {
        int n = nums.size();
        vector<int> lis;
        lis.push_back(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] - lis.back() > k) {
                lis.push_back(nums[i]);
            } else {
                *lower_bound(lis.begin(), lis.end(), nums[i]) = nums[i];
            }
        }
        return lis.size();
    }
    int longestSubsequence(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> lis;
        lis.push_back(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] - lis.back() > k) {
                lis.push_back(nums[i]);
            } else {
                int lb = 0, ub = lis.size();
                while (ub - lb > 1) {
                    int mid = (ub + lb) / 2;
                    if (lis[mid] <= nums[i]) {
                        lb = mid;
                    } else {
                        ub = mid;
                    }
                }
                lis[lb] = nums[i];
            }
        }
        return lis.size();
    }
    int longestSubsequence(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> lis;
        lis.push_back(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] - lis.back() > k) {
                lis.push_back(nums[i]);
            } else {
                lis[lower_bound(lis.begin(), lis.end(), nums[i]) - lis.begin()] = nums[i];
            }
        }
        return lis.size();
    }
};