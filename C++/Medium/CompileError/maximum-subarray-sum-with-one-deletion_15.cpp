class Solution {
public:
    int maximumSum(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> dp(n);
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = max(arr[i], dp[i - 1] + arr[i]);
        }
        int ans = dp[0];
        int sum = 0;
        int maxSum = arr[0];
        for (int i = 0; i < n; i++) {[i + 1]);
        }
        return res;
    }
};