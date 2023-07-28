class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 0) return {};
        sort(nums.begin(), nums.end());
        vector<int> dp(n, 1);
        vector<int> pre(n, -1);
        int maxLen = 1;
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }
        vector<int> ans;
        while (maxIdx != -1) {
            ans.push_back(nums[maxIdx]);
            maxIdx = pre[maxIdx];
        }
        return ans;
    }
};