class Solution {
public:
    int lengthOfLIS(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] - nums[j] <= k) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
    int longestSubsequence(vect
            res = max(res, dp[i]);
        }
        return res;
eturn ans;
    }
};