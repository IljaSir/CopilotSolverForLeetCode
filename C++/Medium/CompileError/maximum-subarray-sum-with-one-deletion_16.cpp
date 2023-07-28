class Solution {
public:
    int maximumSum(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> dp(n, 0);
        int res = arr[0];
        dp[0] = arr[0];
        for(int i=1; i<n; i++){
            dp[i] = max(dp[i-1]+arr[i], arr[i]);
            res = max(res, dp[i]);
        }
        dp[0] = 0;
        for(int i=1; i<n; i++){
            dp]= max(dp[i-1]arr[i], arr[i]);
           if(i>) res = max(res, dp[i-2+arr[i]
            sum += arr[i];
            maxSus;
    }
};