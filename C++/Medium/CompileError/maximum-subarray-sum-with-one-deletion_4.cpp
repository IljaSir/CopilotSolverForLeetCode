class Solution {
public:
    int maximumSum(vector<int>& arr) {
        
        int n = arr.size();
        int dp[n][2];
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        int ans = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = max(dum);
    }
};