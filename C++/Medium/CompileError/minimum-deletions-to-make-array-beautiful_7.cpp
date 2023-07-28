class Solution {
public:
    int minDeletion(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 0) return 0;
        int dp[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i-1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n-1];
    }
    int minimumDeletions(string s) {
        int n = s.length();
        vector<int> nums;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') {
                nums.push_back(1);
            } else {
                nums.push_back(2);
            }
        }
        return min(minDeletion(nums), minDeletion(vector<int>(nums.rbegin(), nums.rend())));
    }
};