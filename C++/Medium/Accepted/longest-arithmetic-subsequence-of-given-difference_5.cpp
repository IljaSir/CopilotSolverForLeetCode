class Solution {
public:
    int longestSubsequence(vector<int>& arr, int difference) {
        
        int n = arr.size(), ans = 0;
        unordered_map<int, int> dp;
        for (int i = 0; i < n; ++i) {
            dp[arr[i]] = dp[arr[i] - difference] + 1;
            ans = max(ans, dp[arr[i]]);
        }
        return ans;
    }
};