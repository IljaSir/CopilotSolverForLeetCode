class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> dp(n);
        dp[0] = arr[0] % 2;
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + arr[i] % 2;
            ans += dp[i];
        }
        return ans % int(1e9 + 7);
    }
};