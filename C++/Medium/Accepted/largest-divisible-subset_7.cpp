class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        
        vector<int> dp(nums.size(), 1);
        vector<int> prev(nums.size(), -1);
        int max_index = 0;
        sort(nums.begin(), nums.end());
        for (int i = 1; i < nums.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[max_index]) {
                max_index = i;
            }
        }
        vector<int> ans;
        while (max_index != -1) {
            ans.push_back(nums[max_index]);
            max_index = prev[max_index];
        }
        return ans;
    }
};