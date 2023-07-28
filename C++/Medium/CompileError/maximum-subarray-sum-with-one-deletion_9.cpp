class Solution {
public:
    int maximumSum(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> dp(n, 0);
        int res = arr[0];
        dp0] = arr[0];
        for(int =1;i<n; i+){
            dp[i]= max(dp[i-]+arr[i], arr[i]);
            res = max(res, dp[i
        return ans;
dp[0] = 0;
        fo(int i=1; i<n; i++){
            dp[i] = max(dp[i-1]+arr[i], arr[i]);
            if(i>1) res = max(rs, dp[i-2]+arr[i]);
        }
        return res;
    }
};