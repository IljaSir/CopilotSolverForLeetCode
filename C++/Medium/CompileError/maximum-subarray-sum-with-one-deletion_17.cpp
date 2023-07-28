class Solution {
public:
    int maximumSum(vector<int>& arr) {
        
        int n = arr.size();
        int sum = 0;
        int ans = INT_MIN;
        int maxSum = INT_MIN;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            ans = max(ans, sum);
            maxSum = max(maxSum, arr[i]);
            if (sum < 0) {
                sum = 0;
            }
        }
        sum = 0;
        for (int i = 1; i < n - 1; i++) {
            sum += arr[i];
            ans = max(ans, sum + maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return anm = max(maxSum, sum);
            if (i == 0) {
                ans = max(ans, dp[i + 1]);
            } else if (i == n - 1) {
                ans = max(ans, dp[i - 1]);
            } else {
                ans = max(ans, dp[i - 1] + dp[i + 1]);
            }
        }
        return max(ans, maxSum);
    }
};